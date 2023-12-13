function searchFromArea() {
    // 選択されたボタンのラベルを更新  // 更新所選按鈕的標籤
    updateSelectedButtonLabel('地域から検索');
    // '/get_all_prefectures' エンドポイントからデータを取得// 從 '/get_all_prefectures' 端點獲取數據
    fetch('/get_all_prefectures')
        .then(response => response.json()) // JSONデータに変換// 轉換為 JSON 數據
        .then(data => {
            console.log('サーバーからのデータ:', data);
            // 取得したデータを利用してエリアボタンを作成// 利用獲取的數據創建區域按鈕
            createAreaButtons(data);
        })
        .catch(error => {
            console.error('データの取得エラー:', error);
        });
}
function createAreaButtons(data) {
    // ボタンを含むコンテナを取得する// 取得包含按鈕的容器
    var buttonContainer = document.getElementById('button-container');
    buttonContainer.innerHTML = ''; // コンテナ内の内容をクリア// 清空容器內容
    // データを反復処理してボタンを作成する// 逐筆處理數據，並創建按鈕
    data.forEach(item => {
        // ボタン要素を作成する// 創建按鈕元素
        var button = document.createElement('button');
        // ボタンのテキストをデータアイテムの値に設定する// 設置按鈕文本為數據項的值
        button.innerText = item;
        button.classList.add('AreaBtn');
        // クリックイベントリスナーを追加し、クリック時に対応するURLにリダイレクトする// 添加點擊事件監聽器，點擊時將重定向到相應的URL
        button.addEventListener('click', function() {
            console.log('Clicked button with value:', item);
            var targetUrl = '/get_all_city_by_prefectures?prefecture=' + item;
            window.location.href = targetUrl;
        });
        // ボタンをコンテナに追加する// 添加按鈕到容器中
        buttonContainer.appendChild(button);
    });
}
function searchFromLine() {
    // 選択されたボタンのラベルを更新// 更新選定按鈕的標籤
    updateSelectedButtonLabel('路線から検索');
    // '/get_all_prefectures' エンドポイントからデータを取得// 從 '/get_all_prefectures' 端點獲取數據
    fetch('/get_all_prefectures')
        .then(response => response.json()) // JSONデータに変換// 轉換為 JSON 數據
        .then(data => {
            console.log('サーバーからのデータ:', data);
            // 取得したデータを利用してエリアボタンを作成// 利用獲取的數據創建區域按鈕
            createAreaButtons2(data);
        })
        .catch(error => {
            console.error('データの取得エラー:', error);
        });
}
function createAreaButtons2(data) {
    // ボタンを含むコンテナを取得する// 取得包含按鈕的容器
    var buttonContainer = document.getElementById('button-container');
    buttonContainer.innerHTML = ''; // コンテナ内の内容をクリア// 清空容器內容
    // データを反復処理してボタンを作成する// 透過數據創建按鈕
    data.forEach(item => {
        // ボタン要素を作成する// 創建按鈕元素
        var button = document.createElement('button');
        // ボタンのテキストをデータアイテムの値に設定する // 將按鈕文本設定為數據項的值
        button.innerText = item;
        button.classList.add('AreaBtn2');
        // クリックイベントリスナーを追加し、クリック時に対応するURLにリダイレクトする// 添加點擊事件監聽器，點擊時重定向到相應的URL
        button.addEventListener('click', function() {
            console.log('Clicked button with value:', item);
            var targetUrl = '/get_line_by_prefectures?prefecture=' + item;
            window.location.href = targetUrl;
        });
        // ボタンをコンテナに追加する// 添加按鈕到容器中
        buttonContainer.appendChild(button);
    });
}
function updateSelectedButtonLabel(buttonText) {
    // 'selectedButtonLabel' のIDを持つ要素を取得// 通過ID獲取帶有 'selectedButtonLabel' 的元素
    var label = document.getElementById('selectedButtonLabel');
    // ラベルのテキストコンテンツを指定のボタンテキストに更新// 更新標籤的文本內容為指定的按鈕文本
    label.textContent = buttonText;
}
