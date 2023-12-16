//==========================================================load data=========================================
//取的目前頁面的pmid
const currentPath = window.location.pathname;
const pmIdMatch = currentPath.match(/\d+/);
// 在全局范围定义一个数组，用于存储已选的路线
var selectedLines = [];
// 在全局范围定义一个数组，用于存储已选的車站
var selectedStation = [];

if (pmIdMatch) {
    const pmId = pmIdMatch[0];
    fetch(`/get_pm_detail1_by_pmid/${pmId}`)  // 修改这里的 URL
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            //data中的值
            console.log('Property Detail:', data);
            
            //將值傳入的lineName和stationName存入全域變數
            
            selectedLines.push(data.lineName);
            selectedStation.push(data.stationName);
            
            // 填充页面的lineName和stationName
            document.getElementById('lineName').innerText ="lineName: "+data.lineName;
            document.getElementById('stationName').innerText ="stationName: "+data.stationName;
			// 填充页面的输入字段
            document.getElementById('building-name').value = data.buildingName;
            document.getElementById('building-tower').value = data.buildingTower;
            document.getElementById('building-floor').value = data.buildingFloor;
            document.getElementById('building-room').value = data.buildingRoom;
            document.getElementById('residence-address').value = data.residenceAddress;
            document.getElementById('registration-record').value = data.registrationRecord;
            document.getElementById('building-structure').value = data.buildingStructure;
            document.getElementById('number-of-units').value = data.numberOfUnits;
            document.getElementById('year').value = data.constructionYear;
            document.getElementById('big-construction-date-year').value=data.bigConstructionDate;
            document.getElementById('unit-number').value = data.unitNumber;
            document.getElementById('layout').value = data.layout;
            document.getElementById('floor-area').value = data.floorArea;
            document.getElementById('floor-area2').value = data.otherFloorArea; 
            
            //buildingType 是一个字符串，表示选中的建筑类型
            var BuildingType = data.buildingType;
            // 查找所有的建筑类型的 checkbox
            var checkboxes = document.querySelectorAll('input[name="building-type-radios"]');
            // 遍历所有的 checkbox
            checkboxes.forEach(function (checkbox) {
                // 判断当前 checkbox 是否与 buildingType 匹配
                if (checkbox.value === BuildingType) {
                    // 选中这个 checkbox
                    checkbox.checked = true;
                } else {
                    // 其他 checkbox 不选中
                    checkbox.checked = false;
                }
            });

            
        })
        .catch(error => {
            console.error('Error:', error);
        });
} else {
    console.error('No numeric value found in the URL');
}

//==========================================================================================================









function record(){
	// ボタンを含むコンテナを取得
    var buttonContainer = document.getElementById('button-container');
    buttonContainer.innerHTML = '';
    // 路线轉換為字串
    var selectedLinesString = selectedLines.join(',');
    console.log('Selected lines as string:', selectedLinesString);
    // 車站轉換為字串
    var selectedStationString = selectedStation.join(',');
    console.log('Selected lines as string:', selectedStationString);
    
    
    
    
    
    const pmId = pmIdMatch[0];
    // 收集所有填寫的資料
    var formData = {
      pmId:pmId,
      buildingName: document.getElementById('building-name').value,
      buildingTower: document.getElementById('building-tower').value,
      buildingFloor: document.getElementById('building-floor').value,
      buildingRoom: document.getElementById('building-room').value,
      residenceAddress: document.getElementById('residence-address').value,
      registrationRecord: document.getElementById('registration-record').value,
      buildingType: getSelectedBuildingType(), // 取得選中的建築種類
      buildingStructure: document.getElementById('building-structure').value,
      numberOfUnits: document.getElementById('number-of-units').value,
      constructionYear: document.getElementById('year').value,
      bigConstructionDate: getBigConstructionDate(), // 取得大規模修繕年份或不詳
      unitNumber: document.getElementById('unit-number').value,
      layout: document.getElementById('layout').value,
      floorArea: document.getElementById('floor-area').value,
      otherFloorArea: document.getElementById('floor-area2').value,
      
      lineName: selectedLinesString,
	  stationName: selectedStationString
    };
  // 記錄或使用捕捉的值執行進一步的操作 
  console.log(formData);
  
  
	// ユーザーに確認を求める
	var userConfirmed = confirm('本当に提出しますか？');
	if (!userConfirmed) {
	    return; // ユーザーがキャンセルした場合、後続の操作を行わない
	}
	  // サーバーにリクエストを送信
	fetch('/update_pm', {
	    method: 'POST',
	    headers: {
	        'Content-Type': 'application/json'
	    },
	    body: JSON.stringify(formData)
	})
	.then(response => response.json())
	.then(data => {
	    console.log('data from DB:', data);
	})
	.catch(error => {
	    console.error('error:', error);
	});
	// アラートを表示
	alert('建物が更新されました');
  
}
// Helper 函數：取得選中的建築種類
function getSelectedBuildingType() {
  var selectedOption = document.querySelector('input[name="building-type-radios"]:checked');
  return selectedOption ? selectedOption.value : '';
}
// Helper 函數：取得大規模修繕年份或不詳
function getBigConstructionDate() {
  var unknownCheckbox = document.getElementById('unknown-construction-checkbox');
  if (unknownCheckbox && unknownCheckbox.checked) {
    return '不詳';
  } else {
    return document.getElementById('big-construction-date-year').value;
  }
}








// 監聽「不詳」checkbox 變動事件
var unknownConstructionCheckbox = document.getElementById('unknown-construction-checkbox');
if (unknownConstructionCheckbox) {
    unknownConstructionCheckbox.addEventListener('change', function () {
        // 取得大規模修繕年份輸入框
        var bigConstructionDateYear = document.getElementById('big-construction-date-year');
        // 如果勾選「不詳」，清空並禁用年份輸入框
        if (this.checked) {
            bigConstructionDateYear.value = '';
            bigConstructionDateYear.disabled = true;
        } else {
            // 如果未勾選「不詳」，啟用年份輸入框
            bigConstructionDateYear.disabled = false;
        }
    });
} else {
    console.error('Element with id "unknown-construction-checkbox" not found.');
}




//==============================================路線を追加=============================================

function addLine() {
    // '/get_all_prefectures' エンドポイントからデータを取得
    fetch('/get_all_prefectures')
        .then(response => response.json()) // JSONデータに変換
        .then(data => {
            // 取得したデータを利用して駅を追加するための都道府県ボタンを作成
            createPrefectureButtonsForAddLine(data);
        })
        .catch(error => {
            console.error('データの取得エラー:', error);
        });
}
function createPrefectureButtonsForAddLine(data) {
    // 'button-container' のIDを持つ要素を取得
    var buttonContainer = document.getElementById('button-container');
	buttonContainer.innerHTML = '';

    // データを反復処理してボタンを作成する
    data.forEach(item => {
        // ボタン要素を作成する
        var button = document.createElement('button');
        // ボタンのテキストをデータアイテムの値に設定する
        button.innerText = item;
        button.classList.add('AreaBtn3');
        // クリックイベントリスナーを追加し、クリック時に対応する都道府県の市町村を取得する関数を呼び出す
        button.addEventListener('click', function() {
            console.log('Clicked button with value:', item);
			getCityForAddLine(item);
        });
        // ボタンをコンテナに追加する
        buttonContainer.appendChild(button);
    });
}
function getCityForAddLine(item) {
    // '/get_all_city_by_prefectures_value?prefecture=' + item へのリクエストで市町村データを取得
    fetch('/get_all_city_by_prefectures_value?prefecture=' + item)
        .then(response => response.json()) // JSONデータに変換
        .then(data => {
		console.log(data);
            // 取得したデータを利用して駅を追加するための市町村ボタンを作成
            createCityButtonsForAddLine(data);
        })
        .catch(error => {
            console.error('データの取得エラー:', error);
        });
}
function createCityButtonsForAddLine(data) {
    // ボタンを含むコンテナを取得
    var buttonContainer = document.getElementById('button-container');
    buttonContainer.innerHTML = '';
    // データを反復処理してボタンを作成
    data.forEach(item => {
        // ボタン要素を作成
        var button = document.createElement('button');        
        // ボタンのテキストをデータアイテムの値に設定
        button.innerText = item;
        button.classList.add('AreaBtn3');
        // クリックイベントリスナーを追加し、クリック時に対応する市町村の駅を取得する関数を呼び出す
        button.addEventListener('click', function() {
            console.log('Clicked button with value:', item);
            // アドレスに含まれる値を用いて路線情報を取得するリクエストを送信
            fetch('/get_line_by_address_containing_value?address=' + item)
                .then(response => response.json())
                .then(lineData => {
                    console.log('Line data:', lineData);
                    // 取得した路線データを利用して路線ボタンを作成
                    createLineButtonsForAddLine(lineData);
                })
                .catch(error => {
                    console.error('路線データの取得エラー:', error);
                });
        });
        // ボタンをコンテナに追加
        buttonContainer.appendChild(button);
    });
}

function createLineButtonsForAddLine(lineData) {
    // ボタンを含むコンテナを取得
    var buttonContainer = document.getElementById('button-container');
    buttonContainer.innerHTML = '';
    // 路線データを反復処理してボタンを作成
    lineData.forEach(line => {
        var lineButton = document.createElement('button');     
        // ボタンのテキストとして、路線データの特定のプロパティを使用
        lineButton.innerText = line;
        lineButton.classList.add('AreaBtn3');        
        // クリックイベントリスナーを追加し、クリック時に対応する路線の駅フォームを作成する関数を呼び出す
        lineButton.addEventListener('click', function() {
            console.log('Clicked line button with value:', line);
			    // 检查路线是否已选
		    if (!selectedLines.includes(line)) {
		        // 如果路线尚未选中，则存入全局变量
		        selectedLines.push(line);
		        console.log('Selected line:', line);
		        console.log('Selected lines:', selectedLines);
		        document.getElementById('lineName').innerText ="lineName: "+selectedLines;

		    } else {
		        console.log('Line already selected:', line);
		        // 如果路线已经选中，你可以在这里添加一些反馈或其他逻辑
		    }
        });
        // 路線ボタンをコンテナに追加
        buttonContainer.appendChild(lineButton);
    });
}
//==============================================駅を追加=============================================
function addStation() {
    // '/get_all_prefectures' エンドポイントからデータを取得
    fetch('/get_all_prefectures')
        .then(response => response.json()) // JSONデータに変換
        .then(data => {
            // 取得したデータを利用して駅を追加するための都道府県ボタンを作成
            createPrefectureButtonsForAddStation(data);
        })
        .catch(error => {
            console.error('データの取得エラー:', error);
        });
}
function createPrefectureButtonsForAddStation(data) {
    // 'button-container' のIDを持つ要素を取得
    var buttonContainer = document.getElementById('button-container');
	buttonContainer.innerHTML = '';
    // データを反復処理してボタンを作成する
    data.forEach(item => {
        // ボタン要素を作成する
        var button = document.createElement('button');
        // ボタンのテキストをデータアイテムの値に設定する
        button.innerText = item;
        button.classList.add('AreaBtn');
        // クリックイベントリスナーを追加し、クリック時に対応する都道府県の市町村を取得する関数を呼び出す
        button.addEventListener('click', function() {
            console.log('Clicked button with value:', item);
			getCityForAddStation(item);
        });
        // ボタンをコンテナに追加する
        buttonContainer.appendChild(button);
    });
}
function getCityForAddStation(item) {
    // '/get_all_city_by_prefectures_value?prefecture=' + item へのリクエストで市町村データを取得
    fetch('/get_all_city_by_prefectures_value?prefecture=' + item)
        .then(response => response.json()) // JSONデータに変換
        .then(data => {
		console.log(data);
            // 取得したデータを利用して駅を追加するための市町村ボタンを作成
            createCityButtonsForAddStation(data);
        })
        .catch(error => {
            console.error('データの取得エラー:', error);
        });
}
function createCityButtonsForAddStation(data) {
    // ボタンを含むコンテナを取得
    var buttonContainer = document.getElementById('button-container');
    buttonContainer.innerHTML = '';
    // データを反復処理してボタンを作成
    data.forEach(item => {
        // ボタン要素を作成
        var button = document.createElement('button');        
        // ボタンのテキストをデータアイテムの値に設定
        button.innerText = item;
        button.classList.add('AreaBtn');
        // クリックイベントリスナーを追加し、クリック時に対応する市町村の駅を取得する関数を呼び出す
        button.addEventListener('click', function() {
            console.log('Clicked button with value:', item);
            // アドレスに含まれる値を用いて路線情報を取得するリクエストを送信
            fetch('/get_line_by_address_containing_value?address=' + item)
                .then(response => response.json())
                .then(lineData => {
                    console.log('Line data:', lineData);
                    // 取得した路線データを利用して路線ボタンを作成
                    createLineButtonsForAddStation(lineData);
                })
                .catch(error => {
                    console.error('路線データの取得エラー:', error);
                });
        });
        // ボタンをコンテナに追加
        buttonContainer.appendChild(button);
    });
}
function createLineButtonsForAddStation(lineData) {
    // ボタンを含むコンテナを取得
    var buttonContainer = document.getElementById('button-container');
    buttonContainer.innerHTML = '';
    // 路線データを反復処理してボタンを作成
    lineData.forEach(line => {
        var lineButton = document.createElement('button');     
        // ボタンのテキストとして、路線データの特定のプロパティを使用
        lineButton.innerText = line;
        lineButton.classList.add('AreaBtn');        
        // クリックイベントリスナーを追加し、クリック時に対応する路線の駅フォームを作成する関数を呼び出す
        lineButton.addEventListener('click', function() {
            console.log('Clicked line button with value:', line);
			 getStation(line);
        });
        // 路線ボタンをコンテナに追加
        buttonContainer.appendChild(lineButton);
    });
}
// 指定された路線名に対応する駅データを取得し、ボタンを作成して表示する関数
function getStation(line) {
    // サーバーから対応する路線の駅データを取得するためのURL
    var url = '/get_station_by_line?lineName=' + line;
    // フェッチを使用してデータを取得
    fetch(url)
        .then(response => response.json())
        .then(data => {
            // サーバーから取得したデータをコンソールに表示
            console.log('Data from server for ' + line + ':', data);
            // ボタンを作成し、指定されたコンテナに追加する関数を呼び出す
            createStationButtons(data);
        })
        .catch(error => {
            // エラーが発生した場合はコンソールにエラーメッセージを表示
            console.error('Error fetching data:', error);
        });
}
// 駅データをもとにボタンを作成し、指定されたボタンコンテナに追加する関数
function createStationButtons(data) {
    // 'button-container' のIDを持つ要素を取得
    var buttonContainer = document.getElementById('button-container');
	buttonContainer.innerHTML = '';
    // データを反復処理してボタンを作成する
    data.forEach(item => {
        // ボタン要素を作成する
        var button = document.createElement('button');
        // ボタンのテキストをデータアイテムの値に設定する
        button.innerText = item;
        button.classList.add('AreaBtn');
        // クリックイベントリスナーを追加し、クリック時に対応する都道府県の市町村を取得する関数を呼び出す
        button.addEventListener('click', function() {
            console.log('Clicked button with value:', item);
            // 检查車站是否已选
		    if (!selectedStation.includes(item)) {
		        // 如果路线尚未选中，则存入全局变量
		        selectedStation.push(item);
		        console.log('Selected line:', item);
		        console.log('selected Station:', selectedStation);
		        document.getElementById('stationName').innerText ="stationName: "+selectedStation;
		    } else {
		        console.log('Station already selected:', item);
		        // 如果路线已经选中，你可以在这里添加一些反馈或其他逻辑
		    }

        });
        // ボタンをコンテナに追加する
        buttonContainer.appendChild(button);
    });
}




  