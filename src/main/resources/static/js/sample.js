function fetchData() {
    // 使用 Fetch API 發送 GET 請求
    fetch('/api/get_all_prefectures')
        .then(response => response.json())
        .then(data => {
            // 處理從服務器返回的數據
            console.log('Data from server:', data);
            createButtons(data);
        })
        .catch(error => {
            // 處理錯誤
            console.error('Error fetching data:', error);
        });
}

function createButtons(data) {
    // 获取包含按钮的容器
    var buttonContainer = document.getElementById('button-container');

    // 遍历数据并创建按钮
    data.forEach(item => {
        // 创建按钮元素
        var button = document.createElement('button');

        // 设置按钮文本为数据项的值
        button.innerText = item;

        // 添加点击事件监听器，打印相应的值到控制台
        button.addEventListener('click', function() {
            console.log('Clicked button with value:', item);
        });

        // 将按钮添加到容器中
        buttonContainer.appendChild(button);
    });
}