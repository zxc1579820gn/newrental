//================================LOAD TABLE==================================================  
fetch('/get_all_pm')
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json(); // 将响应解析为 JSON
    })
    .then(pmList => {
        // 获取表格元素
        const tableBody = document.querySelector('#pmTable tbody');

            // 遍历 PM 列表，创建表格行并添加到表格中
            pmList.forEach((building, index) => {
                const row = document.createElement('tr');
				//<td>${building.id}</td> 獲取DB的ID
                row.innerHTML = `
                    <td>${index + 1}</td>
                    <td>${building.buildingName}</td>
                    <td>${building.residenceAddress}</td>
                    <td>${building.buildingType}</td>
                    <td>${building.floorArea}</td>
                    <td>${building.otherFloorArea}</td>
                    <td>
                    <button onclick="editButtonClick(${building.id})">編集</button>
                    <button onclick="delButtonClick(${building.id})">削除</button>
                    </td>
                `;
                tableBody.appendChild(row);
            });
    })
    .catch(error => {
        console.error('Error:', error);
    });
//=================================================================================================================    
//編集BTN
function editButtonClick(buildingId) {
	console.log('editButtonClick:', buildingId);
	// ターゲットURLを指定// 指定目標URL
	const url = '/editDetailPMmanager/' + buildingId;
	// ページを指定のURLにリダイレクト// 將頁面重定向到指定的URL
	window.location.href = url;
}
//削除BTN
function delButtonClick(buildingId) {
	console.log('delButtonClick:', buildingId);
}




function creat(){
        // ターゲットURLを指定// 指定目標URL
        var targetUrl = '/creatPMmanager';
        // ページを指定のURLにリダイレクト// 將頁面重定向到指定的URL
        window.location.href = targetUrl;
}