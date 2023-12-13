//============================================リスト======================================================
function search() {
    // 'button-container' のIDを持つ要素を取得
    var buttonContainer = document.getElementById('button-container');
    // コンテナ内の内容をクリア
    buttonContainer.innerHTML = '';
    // 'stationForm' のIDを持つ要素を取得
	var stationFormExist = document.getElementById('stationForm');	
	// フォームの存在を確認する
	if (stationFormExist) {
	    // 存在する場合、削除します
	    stationFormExist.parentNode.removeChild(stationFormExist);
	}
	// 'lineForm' のIDを持つ要素を取得
	var lineFormExist = document.getElementById('lineForm');
	// フォームの存在を確認する
    if (lineFormExist) {
	    // 存在する場合、削除します
        lineFormExist.parentNode.removeChild(lineFormExist);
    }
    // '都道府県から検索' ボタンを作成
    var searchFromPrefectureBtn = document.createElement('button');
    searchFromPrefectureBtn.innerText = '都道府県から検索';
    searchFromPrefectureBtn.classList.add('AreaSearchBtn');
    searchFromPrefectureBtn.addEventListener('click', function() {
        console.log('Clicked 都道府県から検索 button');
        showLineListByPrefectures();
    });
    // '市町村から検索' ボタンを作成
    var searchFromCityBtn = document.createElement('button');
    searchFromCityBtn.innerText = '市町村から検索';
    searchFromCityBtn.classList.add('AreaSearchBtn2');
    searchFromCityBtn.addEventListener('click', function() {
        console.log('Clicked 市町村から検索 button');
        showLineListByAdress();
    });
    // ボタンをコンテナに追加
    buttonContainer.appendChild(searchFromPrefectureBtn);
    buttonContainer.appendChild(searchFromCityBtn);
}
//============================================編集======================================================
function edit() {
    // 'button-container' のIDを持つ要素を取得
    var buttonContainer = document.getElementById('button-container');
    // コンテナ内の内容をクリア
    buttonContainer.innerHTML = '';
    // 'stationForm' のIDを持つ要素を取得
	var stationFormExist = document.getElementById('stationForm');	
	// フォームの存在を確認する
	if (stationFormExist) {
	    // 存在する場合、削除します
	    stationFormExist.parentNode.removeChild(stationFormExist);
	}
	// 'lineForm' のIDを持つ要素を取得
	var lineFormExist = document.getElementById('lineForm');
	// フォームの存在を確認する
    if (lineFormExist) {
	    // 存在する場合、削除します
        lineFormExist.parentNode.removeChild(lineFormExist);
    }
    // '駅を追加' ボタンを作成
    var searchFromPrefectureBtn = document.createElement('button');
    searchFromPrefectureBtn.innerText = '駅を追加';
    searchFromPrefectureBtn.classList.add('AreaEditBtn');
    searchFromPrefectureBtn.id = 'addStationBtn';
    searchFromPrefectureBtn.addEventListener('click', function() {
        console.log('Clicked add station button');
        showLineListByAdressForAddStation();
    });
    // '路線を追加' ボタンを作成
    var searchFromCityBtn = document.createElement('button');
    searchFromCityBtn.innerText = '路線を追加';
    searchFromCityBtn.classList.add('AreaEditBtn');
    searchFromCityBtn.id = 'addLineBtn';
    searchFromCityBtn.addEventListener('click', function() {
        console.log('Clicked add line button');
		createLineForm();
    });
    // ボタンをコンテナに追加
    buttonContainer.appendChild(searchFromPrefectureBtn);
    buttonContainer.appendChild(searchFromCityBtn);
}
//============================================都道府県から検索======================================================
function showLineListByPrefectures() {
    // サーバーから都道府県データを取得
    fetch('/get_all_prefectures')
        .then(response => response.json())
        .then(data => {
            // サーバーからのデータをコンソールに表示
            console.log('Data from server:', data);
            // 取得したデータを元に都道府県ボタンを作成
            createPrefectureButtons(data);
        })
        .catch(error => {
            // エラーが発生した場合はコンソールに表示
            console.error('Error fetching data:', error);
        });
}
function createPrefectureButtons(data) {
    // ボタンを含むコンテナを取得
    var buttonContainer = document.getElementById('button-container');
    buttonContainer.innerHTML = ''; // コンテナ内の既存のボタンをクリア
    // データを反復処理してボタンを作成
    data.forEach(item => {
        // ボタン要素を作成
        var button = document.createElement('button');
        // ボタンのテキストをデータアイテムの値に設定
        button.innerText = item;
        button.classList.add('AreaBtn'); // ボタンにクラスを追加
		// ボタンがクリックされたときのイベントリスナーを設定
        button.addEventListener('click', function() {
            console.log('Clicked button with value:', item);
            // 選択された都道府県に基づいてサーバーから路線データを取得するURLを構築
            var targetUrl = '/manager_get_line_by_prefectures?prefecture=' + item;
            window.location.href = targetUrl; // ページをリダイレクト
        });
        // ボタンをコンテナに追加
        buttonContainer.appendChild(button);
    });
}
//============================================市町村から検索======================================================
function showLineListByAdress() {
    // サーバーから都道府県データを取得
    fetch('/get_all_prefectures')
        .then(response => response.json())
        .then(data => {
            console.log('Data from server:', data);
            // サーバーから取得した都道府県データを元に都道府県ボタンを作成
            createPrefectureButtons2(data);
        })
        .catch(error => {
            console.error('Error fetching data:', error);
        });
}
// 都道府県データを元に都道府県ボタンを作成する関数
function createPrefectureButtons2(data) {
    // ボタンを表示するコンテナを取得する
    var buttonContainer = document.getElementById('button-container');
    buttonContainer.innerHTML = ''; // コンテナ内の要素をクリア
    // データを反復処理してボタンを作成
    data.forEach(item => {
        // ボタン要素を作成
        var button = document.createElement('button');
        // ボタンのテキストを都道府県データの値に設定
        button.innerText = item;
        button.classList.add('AreaBtn2'); // ボタンにスタイルクラスを追加
        // ボタンがクリックされたときのイベントリスナーを設定
        button.addEventListener('click', function() {
            console.log('Clicked button with value:', item);
            // クリックされた都道府県に関連する市町村データを取得する関数を呼び出し
            getCity(item);
        });
        // ボタンをコンテナに追加
        buttonContainer.appendChild(button);
    });
}
// 都道府県に関連する市町村データを取得し、市町村ボタンを作成する関数
function getCity(item) {
    // サーバーから都道府県に関連する市町村データを取得
    fetch('/get_all_city_by_prefectures_value?prefecture=' + item)
        .then(response => response.json())
        .then(data => {
            console.log('Data from server:', data);
            // サーバーから取得した市町村データを元に市町村ボタンを作成
            createCityButtons(data);
        })
        .catch(error => {
            console.error('Error fetching data:', error);
        });
}
// 市町村に関連する路線データを取得し、路線ボタンを作成する関数
function createCityButtons(data) {
    // ボタンを表示するコンテナを取得
    var buttonContainer = document.getElementById('button-container');
    // コンテナ内の要素をクリア
    buttonContainer.innerHTML = '';
    // 取得した市町村データを元にボタンを作成
    data.forEach(item => {
        // ボタン要素を作成
        var button = document.createElement('button');
        // ボタンのテキストを市町村データの値に設定
        button.innerText = item;
        // ボタンにクラスを追加
        button.classList.add('AreaBtn2');
        // ボタンクリック時のイベントを設定
        button.addEventListener('click', function() {
            console.log('Clicked button with value:', item);
            // 市町村に関連する路線データを取得するためのURLを構築
            var targetUrl = '/get_line_by_address_containing?address=' + item;
            // ページを指定したURLに遷移
            window.location.href = targetUrl;
        });
        // ボタンをコンテナに追加
        buttonContainer.appendChild(button);
    });
}
//============================================駅を追加======================================================
function showLineListByAdressForAddStation() {
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
	// 'lineForm' のIDを持つ要素を取得
	var lineFormExist = document.getElementById('lineForm');
	// フォームの存在を確認する
    if (lineFormExist) {
	    // 存在する場合、削除します
        lineFormExist.parentNode.removeChild(lineFormExist);
    }
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
                    createLineButtons(lineData);
                })
                .catch(error => {
                    console.error('路線データの取得エラー:', error);
                });
        });
        // ボタンをコンテナに追加
        buttonContainer.appendChild(button);
    });
}
function createLineButtons(lineData) {
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
			createStationForm(line);
        });
        // 路線ボタンをコンテナに追加
        buttonContainer.appendChild(lineButton);
    });
}

function createStationForm(line) {
    // 既存のフォームを取得
    var existingForm1 = document.getElementById('stationForm');
    if (existingForm1) {
        // 既存のフォームが存在する場合は削除
        existingForm1.parentNode.removeChild(existingForm1);
    }
    var existingForm2 = document.getElementById('lineForm');
    if (existingForm2) {
        // 既存のフォームが存在する場合はそのまま返す
        return existingForm2;
    }
    // 新しいフォームを作成
    var stationForm = document.createElement('form');
    stationForm.setAttribute('id', 'stationForm');
    // 入力フィールドを作成
    var stationNameInput = createInput('text', '駅名', 'stationNameInput');
    var lineNameInput = createInput('text', '路線名', 'lineNameInput', true);
    var addressInput = createInput('text', '住所', 'addressInput');
    // ライン名を入力フィールドに設定
    lineNameInput.value = line;
    // 送信ボタンを作成
    var submitBtn = createStationSubmitButton();
    // 入力フィールドと送信ボタンをフォームに追加
    stationForm.appendChild(stationNameInput);
    stationForm.appendChild(lineNameInput);
    stationForm.appendChild(addressInput);
    stationForm.appendChild(submitBtn);
    // フォームをDOMに追加
    document.body.appendChild(stationForm);

    return stationForm;
}

function createStationSubmitButton() {
    // 提出ボタンを作成
    var submitBtn = document.createElement('button');
    submitBtn.innerText = '提出';
    submitBtn.classList.add('submitBtn');
    // クリックイベントリスナーを追加
    submitBtn.addEventListener('click', function(event) {
        event.preventDefault(); // デフォルトの送信動作を防止
        console.log('submitBtn click');
        // フォームから値を取得
        var stationName = document.getElementById('stationNameInput').value;
        var lineName = document.getElementById('lineNameInput').value;
        var address = document.getElementById('addressInput').value;
        // すべてのフィールドが記入されているか確認
        if (!stationName || !lineName || !address) {
            alert('全ての項目を入力してください');
            return;
        }
        // 住所に駅名を結合
        var addressToDb = address + "(" + stationName + ")";
        // リクエストボディを作成
        var requestBody = {
            stationName: stationName,
            lineName: lineName,
            address: addressToDb
        };
        // ユーザーに確認を求める
		var userConfirmed = confirm('本当に提出しますか？');
		if (!userConfirmed) {
		    return; // ユーザーがキャンセルした場合、後続の操作を行わない
		}
        // サーバーにリクエストを送信
        fetch('/addStationToLine', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestBody)
        })
        .then(response => response.json())
        .then(data => {
            console.log('data from DB:', data);
        })
        .catch(error => {
            console.error('error:', error);
        });
        // アラートを表示
        alert('新しい駅が設定されました');
        // 入力フィールドをクリア
        document.getElementById('stationNameInput').value = '';
        document.getElementById('addressInput').value = '';
    });
    return submitBtn;
}
//============================================路線を追加======================================================
function createLineForm() {
    // 都道府県データを取得
    fetch('/get_all_prefectures')
        .then(response => response.json())
        .then(data => {
            // 関数createLineForm2に都道府県データを渡して呼び出す
            createLineForm2(data);
        })
        .catch(error => {
            console.error('Error fetching data:', error);
        });
}
function createLineForm2(data) {
    // 既存のフォーム1を取得して存在する場合は削除
    var existingForm1 = document.getElementById('stationForm');
    if (existingForm1) {
        existingForm1.parentNode.removeChild(existingForm1);
    }
    // 既存のフォーム2を取得
    var existingForm2 = document.getElementById('lineForm');
    if (existingForm2) {
        return existingForm2; // 既存のフォームがある場合はそのまま返す
    }
    // 新しいフォームを作成
    var lineForm = document.createElement('form');
    lineForm.setAttribute('id', 'lineForm');
    // 入力ボックスを作成
    var stationNameInput = createInput('text', '駅名', 'stationNameInput');
    var lineCdInput = createInput('number', '路線コード', 'lineCdInput');
    var lineNameInput = createInput('text', '路線名', 'lineNameInput');
    var prefNameSelect = createSelect('Prefecture Name', 'prefNameSelect', data);
    var addressInput = createInput('text', '住所', 'addressInput');
    // 提出ボタンを作成
    var submitBtn = createLineSubmitButton();
    // 入力ボックスと提出ボタンをフォームに追加
    lineForm.appendChild(stationNameInput);
    lineForm.appendChild(lineCdInput);
    lineForm.appendChild(lineNameInput);
    lineForm.appendChild(prefNameSelect);
    lineForm.appendChild(addressInput);
    lineForm.appendChild(submitBtn);
    // フォームをDOMに追加
    document.body.appendChild(lineForm);
    return lineForm;
}
function createLineSubmitButton() {
	// '提出' ボタン要素を作成
    var submitBtn = document.createElement('button');
    submitBtn.innerText = '提出';
    submitBtn.classList.add('submitBtn');
    // クリックイベントリスナーを追加
    submitBtn.addEventListener('click', function(event) {
        event.preventDefault();// フォームのデフォルトの送信を防ぐ
        console.log('submitBtn click');
        // フォームから値を取得
        var stationName = document.getElementById('stationNameInput').value;
        var lineCd = document.getElementById('lineCdInput').value;
        var lineName = document.getElementById('lineNameInput').value;
        var prefName = document.getElementById('prefNameSelect').value;
        var address = document.getElementById('addressInput').value;
        // 全てのフィールドが入力されているか確認
        if (!stationName || !lineCd || !lineName || !prefName || !address) {
            alert('全ての項目を入力してください');
            return;
        }
        // データベースに送信するリクエストボディを構築
        var addressToDb = address + "(" + stationName + ")";
        var requestBody = {
            stationName: stationName,
            lineCd: lineCd,
            lineName: lineName,
            prefName: prefName,
            address: addressToDb
        };
        // ユーザーに確認を求める
		var userConfirmed = confirm('本当に提出しますか？');
		if (!userConfirmed) {
		    return; // ユーザーがキャンセルした場合、後続の操作を行わない
		}
        // データベースに新しい路線を追加するリクエストを送信
        fetch('/addLine', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestBody)
        })
        .then(response => {
		    if (response.status === 200) {
		        // 'editBtn' ボタンをクリックして編集画面に戻る
		        document.getElementById('editBtn').click();
		        alert('新しい路線が設定されました');
		        return response.json();
		    } else if (response.status === 409) {
		        // 路線がすでに存在する場合の処理ロジック
		        alert('同じ路線が既に存在します');
		        throw new Error('Conflict: Same line already exists');
		    } else {
		        // その他のステータスコードの処理ロジック
		        throw new Error('Unexpected status: ' + response.status);
		    }
		})
        .then(data => {
            console.log('データベースからのデータ:', data);
        })
        .catch(error => {
            console.error('エラー:', error);
        });
    });
    return submitBtn;
}
//============================================createInput======================================================
function createInput(type, placeholder, id, disabled) {
    var input = document.createElement('input');
    input.setAttribute('type', type);
    input.setAttribute('placeholder', placeholder);
    input.setAttribute('id', id);
    input.classList.add('LineInput');
    // 入力ボックスの無効化設定
    if (disabled) {
        input.setAttribute('disabled', 'disabled');
    }
    return input;
}
//============================================createSelect======================================================
function createSelect(label, id, options) {
    var select = document.createElement('select');
    select.setAttribute('id', id);
    select.classList.add('LineInput');
    // ラベルの作成
    var labelElement = document.createElement('label');
    labelElement.innerText = label;
    labelElement.setAttribute('for', id);
    // ラベルをセレクトボックスに追加
    select.appendChild(labelElement);
    // セレクトボックスにオプションを追加
    options.forEach(optionText => {
        var option = document.createElement('option');
        option.value = optionText;
        option.text = optionText;
        select.appendChild(option);
    });
    return select;
}










