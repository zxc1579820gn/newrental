// 在全局范围定义一个数组，用于存储已选的路线
var selectedLines = [];
// 在全局范围定义一个数组，用于存储已选的車站
var selectedStation = [];

//====================================Add Lines And Station==========================================
document.addEventListener('DOMContentLoaded', function () {
    // 获取包含线路按钮的容器
    var lineContainer = document.getElementById('line-container');
    // 获取包含站点按钮的容器
    var stationContainer = document.getElementById('station-container');
    // 将 selectedLines 中的值作为线路按钮添加到容器
    selectedLines.forEach(function (line) {
        addButton(line, lineContainer, selectedLines);
    });
    // 将 selectedStation 中的值作为站点按钮添加到容器
    selectedStation.forEach(function (station) {
        addButton(station, stationContainer, selectedStation);
    });
});
// 添加按钮的通用函数
function addButton(value, container, array) {
    var button = document.createElement('button');
    button.textContent = value;
    // 根据数组类型设置不同的class
    if (array === selectedLines) {
        button.className = 'AreaBtn3';
    } else if (array === selectedStation) {
        button.className = 'AreaBtn';
    }
    // 添加点击事件处理程序
    button.addEventListener('click', function () {
        // 当按钮被点击时，从相应的数组中移除相应的值
        var index = array.indexOf(value);
        if (index !== -1) {
            array.splice(index, 1);
            // 更新页面
            updateButtons();
            document.getElementById('stationName').innerText ="stationName: "+selectedStation;
			document.getElementById('lineName').innerText ="lineName: "+selectedLines;
        }
    });
    // 将按钮添加到容器中
    container.appendChild(button);
}
// 更新按钮的函数，当 selectedStation 或 selectedLines 改变时调用
function updateButtons() {
    var lineContainer = document.getElementById('line-container');
    var stationContainer = document.getElementById('station-container');
    // 清空容器
    lineContainer.innerHTML = '';
    stationContainer.innerHTML = '';
    // 将 selectedLines 中的值作为线路按钮重新添加到容器
    selectedLines.forEach(function (line) {
        addButton(line, lineContainer, selectedLines);
    });
    // 将 selectedStation 中的值作为站点按钮重新添加到容器
    selectedStation.forEach(function (station) {
        addButton(station, stationContainer, selectedStation);
    });
}
//=======================================================================================================
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
    
    
    
    
    
    
    // 收集所有填寫的資料
    var formData = {
      //=========================================賃貸借の目的物===================================
      //名 称
      buildingName: document.getElementById('building-name').value,
      // 棟
      buildingTower: document.getElementById('building-tower').value,
      //階
      buildingFloor: document.getElementById('building-floor').value,
      //号室
      buildingRoom: document.getElementById('building-room').value,
      //住居表示
      residenceAddress: document.getElementById('residence-address').value,
      //登記簿
      registrationRecord: document.getElementById('registration-record').value,
      //種 類
      buildingType: getSelectedBuildingType(), // 取得選中的建築種類
      //構 造
      buildingStructure: document.getElementById('building-structure').value,
      //戸 数
      numberOfUnits: document.getElementById('number-of-units').value,
      //建築時期
      constructionYear: document.getElementById('year').value,
      //大規模修繕を
      bigConstructionDate: getBigConstructionDate(), // 取得大規模修繕年份或不詳
      //住戸番号
      unitNumber: document.getElementById('unit-number').value,
      //間取り
      layout: document.getElementById('layout').value,
      //床 面 積
      floorArea: document.getElementById('floor-area').value,
      // 其他床 面 積
      otherFloorArea: document.getElementById('floor-area2').value,
      //==================================住戸部分の設備==========================================
      // 電気
	  electricity: document.querySelector('input[name="electricity"]:checked').value,
	  electricityContext: document.getElementById('electricity-context').value,
	  electricityRemarks: document.getElementById('electricity-remarks').value,
	  // ガス
	  gas: document.querySelector('input[name="gas"]:checked').value,
	  gasContext: document.getElementById('gas-context').value,
	  gasRemarks: document.getElementById('gas-remarks').value,
	  //コンロ
	  stoveValue: document.querySelector('input[name="stove"]:checked').value,
	  stoveContext: document.getElementById('stove-context').value,
	  stoveRemarks: document.getElementById('stove-remarks').value,
	  //上水道
	  waterSupplyValue: document.querySelector('input[name="water-supply"]:checked').value,
	  waterSupplyContext: document.getElementById('water-supply-context').value,
	  waterSupplyRemarks: document.getElementById('water-supply-remarks').value,
	  //下水道
	  sewerageValue: document.querySelector('input[name="sewerage"]:checked').value,
	  sewerageContext: document.getElementById('sewerage-context').value,
	  sewerageRemarks: document.getElementById('sewerage-remarks').value,
	  // 台所
	  kitchenValue: document.querySelector('input[name="kitchen"]:checked').value,
	  kitchenContext: document.getElementById('kitchen-context').value,
	  kitchenRemarks: document.getElementById('kitchen-remarks').value,
	  //トイレ
	  toiletValue: document.querySelector('input[name="toilet"]:checked').value,
	  toiletContext: document.getElementById('toilet-context').value,
	  toiletRemarks: document.getElementById('toilet-remarks').value,
	  // 浴室
	  bathroomValue: document.querySelector('input[name="bathroom"]:checked').value,
	  bathroomContext: document.getElementById('bathroom-context').value,
	  bathroomRemarks: document.getElementById('bathroom-remarks').value,
	   // 洗面台
	  washbasinValue: document.querySelector('input[name="washbasin"]:checked').value,
	  washbasinContext: document.getElementById('washbasin-context').value,
	  washbasinRemarks: document.getElementById('washbasin-remarks').value,
      // 洗濯機置場
	  laundryAreaValue: document.querySelector('input[name="laundry-area"]:checked').value,
	  laundryAreaContext: document.getElementById('laundry-area-context').value,
	  laundryAreaRemarks: document.getElementById('laundry-area-remarks').value,
	  // 給湯設備
	  waterHeaterValue: document.querySelector('input[name="water-heater"]:checked').value,
	  waterHeaterContext: document.getElementById('water-heater-context').value,
	  waterHeaterRemarks: document.getElementById('water-heater-remarks').value,
	  // 冷暖房設備（エアコン）
	  airConditionerValue: document.querySelector('input[name="air-conditioner"]:checked').value,
	  airConditionerContext: document.getElementById('air-conditioner-context').value,
	  airConditionerRemarks: document.getElementById('air-conditioner-remarks').value,
      	// 照明器具
		lightingValue: document.querySelector('input[name="lighting"]:checked').value,
		lightingContext: document.getElementById('lighting-context').value,
		lightingRemarks: document.getElementById('lighting-remarks').value,
		// 備付家具
		furnitureValue: document.querySelector('input[name="furniture"]:checked').value,
		furnitureContext: document.getElementById('furniture-context').value,
		furnitureRemarks: document.getElementById('furniture-remarks').value,
		// 地デジ対応
		digitalTvValue: document.querySelector('input[name="digital-tv"]:checked').value,
		digitalTvContext: document.getElementById('digital-tv-context').value,
		digitalTvRemarks: document.getElementById('digital-tv-remarks').value,
		// CATV対応
		catvValue: document.querySelector('input[name="catv"]:checked').value,
		catvContext: document.getElementById('catv-context').value,
		catvRemarks: document.getElementById('catv-remarks').value,
		 // インターネット
		internetValue: document.querySelector('input[name="internet"]:checked').value,
		internetContext: document.getElementById('internet-context').value,
		internetRemarks: document.getElementById('internet-remarks').value,
		// トランクルーム
		trunkRoom: document.querySelector('input[name="trunk-room"]:checked').value,
		trunkRoomContext: document.getElementById('trunk-room-context').value,
		trunkRoomRemarks: document.getElementById('trunk-room-remarks').value,
		 // 専用庭
		privateGarden: document.querySelector('input[name="private-garden"]:checked').value,
		privateGardenContext: document.getElementById('private-garden-context').value,
		privateGardenRemarks: document.getElementById('private-garden-remarks').value,
		// ルーフバルコニー
		roofBalcony: document.querySelector('input[name="roof-balcony"]:checked').value,
		roofBalconyContext: document.getElementById('roof-balcony-context').value,
		roofBalconyRemarks: document.getElementById('roof-balcony-remarks').value,
		// 鍵
		keyValue: document.querySelector('input[name="key"]:checked').value,
		keyContext: document.getElementById('key-context').value,
		keyRemarks: document.getElementById('key-remarks').value,
      //==================================共用部分の設備・施設==========================================
        // エレベーター
		elevatorValue: document.querySelector('input[name="elevator"]:checked').value,
		elevatorContext: document.getElementById('elevator-context').value,
		elevatorRemarks: document.getElementById('elevator-remarks').value,
		// オートロック
		autoLockValue: document.querySelector('input[name="auto-lock"]:checked').value,
		autoLockContext: document.getElementById('auto-lock-context').value,
		autoLockRemarks: document.getElementById('auto-lock-remarks').value,
		// メールボックス
		mailboxValue: document.querySelector('input[name="mailbox"]:checked').value,
		mailboxContext: document.getElementById('mailbox-context').value,
		mailboxRemarks: document.getElementById('mailbox-remarks').value,
		// 宅配ボックス
		deliveryBoxValue: document.querySelector('input[name="delivery-box"]:checked').value,
		deliveryBoxContext: document.getElementById('delivery-box-context').value,
		deliveryBoxRemarks: document.getElementById('delivery-box-remarks').value,
		// トランクルーム
		storageRoom: document.querySelector('input[name="storage-room"]:checked').value,
		storageRoomContext: document.getElementById('storage-room-context').value,
		storageRoomRemarks: document.getElementById('storage-room-remarks').value,
		// 駐車場
		parking: document.querySelector('input[name="parking"]:checked').value,
		parkingContext: document.getElementById('parking-context').value,
		parkingRemarks: document.getElementById('parking-remarks').value,
		// 駐輪場
		bikeParking: document.querySelector('input[name="bike-parking"]:checked').value,
		bikeParkingContext: document.getElementById('bike-parking-context').value,
		bikeParkingRemarks: document.getElementById('bike-parking-remarks').value,
		// バイク置場
		motorcycleParking: document.querySelector('input[name="motorcycle-parking"]:checked').value,
		motorcycleParkingContext: document.getElementById('motorcycle-parking-context').value,
		motorcycleParkingRemarks: document.getElementById('motorcycle-parking-remarks').value,
		//==================================契約期間==========================================
		// 契約始期
		contractStartDate: document.getElementById('contract-start-date').value,
		// 契約終期
		contractEndDate: document.getElementById('contract-end-date').value,
		// 合計契約時間
		totalContractDuration: document.getElementById('total-contract-duration').value,
		// 目的物件の引渡日
		propertyDeliveryDate: document.getElementById('property-delivery-date').value,
		
		
		
      //lineName AND stationName
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
	fetch('/save_pm', {
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
	alert('新しい建物が設定されました');
  
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
		        updateButtons();
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
		        updateButtons();
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

