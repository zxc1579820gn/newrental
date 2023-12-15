function manager() {
    // ボタン要素を取得// 獲取按鈕元素
    var button = document.getElementById('managerbtn');
    // クリックイベントリスナーを追加// 添加點擊事件監聽器
    button.addEventListener('click', function() {
        // ターゲットURLを指定// 指定目標URL
        var targetUrl = '/manager';
        // ページを指定のURLにリダイレクト// 將頁面重定向到指定的URL
        window.location.href = targetUrl;
    });
}
function client() {
    // ボタン要素を取得
    var button = document.getElementById('clientbtn');
    // クリックイベントリスナーを追加
    button.addEventListener('click', function() {
        // ターゲットURLを指定
        var targetUrl = '/client';
        // ページを指定のURLにリダイレクト
        window.location.href = targetUrl;
    });
}
function PMmanager() {
    // ボタン要素を取得
    var button = document.getElementById('PMmanagerbtn');
    // クリックイベントリスナーを追加
    button.addEventListener('click', function() {
        // ターゲットURLを指定
        var targetUrl = '/PMmanager';
        // ページを指定のURLにリダイレクト
        window.location.href = targetUrl;
    });
}
function PMclient() {
    // ボタン要素を取得
    var button = document.getElementById('PMclientbtn');
    // クリックイベントリスナーを追加
    button.addEventListener('click', function() {
        // ターゲットURLを指定
        var targetUrl = '/PMclient';
        // ページを指定のURLにリダイレクト
        window.location.href = targetUrl;
    });
}


























