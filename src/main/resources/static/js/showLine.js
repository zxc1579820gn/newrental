// フォームから選択された路線名を取得し、それに基づいて駅データを表示する関数
function submitForm() {
    // 'selectedLineNames' という名前のすべてのチェックボックスを取得
    var checkboxes = document.querySelectorAll('input[name="selectedLineNames"]:checked');
    // 表示するコンテナを取得
    var mainContainer = document.getElementById('main-container');
    // 表示コンテナをクリア
    mainContainer.innerHTML = '';
    // 選択された各チェックボックスについて処理
    checkboxes.forEach(function (checkbox) {
        // チェックボックスから路線名を取得
        var lineName = checkbox.value;
        // ラベルを作成し main-container に追加
        var label = document.createElement('label');
        label.innerText = lineName;
        mainContainer.appendChild(label);
        // ボタンコンテナを作成し main-container に追加
        var buttonContainer = document.createElement('div');
        buttonContainer.id = 'button-container-' + lineName;
        mainContainer.appendChild(buttonContainer);
        // 対応する路線名に基づいて駅データを取得して表示する関数を呼び出す
        getStation(lineName, buttonContainer);
    });
}
// 指定された路線名に対応する駅データを取得し、ボタンを作成して表示する関数
function getStation(lineName, buttonContainer) {
    // サーバーから対応する路線の駅データを取得するためのURL
    var url = '/get_station_by_line?lineName=' + lineName;
    // フェッチを使用してデータを取得
    fetch(url)
        .then(response => response.json())
        .then(data => {
            // サーバーから取得したデータをコンソールに表示
            console.log('Data from server for ' + lineName + ':', data);
            // ボタンを作成し、指定されたコンテナに追加する関数を呼び出す
            createButtons(data, buttonContainer);
        })
        .catch(error => {
            // エラーが発生した場合はコンソールにエラーメッセージを表示
            console.error('Error fetching data:', error);
        });
}
// 駅データをもとにボタンを作成し、指定されたボタンコンテナに追加する関数
function createButtons(data, buttonContainer) {
    // データを反復処理してボタンを作成
    data.forEach(station => {
        // ボタン要素を作成
        var button = document.createElement('button');
        // ボタンのテキストをデータアイテムの値に設定
        button.innerText = station;
        button.classList.add('lineBtn');
        button.addEventListener('click', function() {
            // ボタンがクリックされたときの処理（ここではコンソールに駅の情報を表示）
            console.log('Clicked button with station:', station);
        });
        // ボタンをコンテナに追加
        buttonContainer.appendChild(button);
    });
}

