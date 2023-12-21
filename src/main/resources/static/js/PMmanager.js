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
                    <td>${building.id}</td>
                    <td>${building.buildingName}</td>
                    <td>${building.residenceAddress}</td>
                    <td>${building.buildingType}</td>
                    <td>${building.floorArea}</td>
                    <td>${building.otherFloorArea}</td>
                    <td>
	                    <div class="fromBtn">
		                    <button onclick="editButtonClick(${building.id})" class="editBtn" >編集</button>
		                    <button onclick="delButtonClick(${building.id})" class="delBtn" >削除</button>
	                    </div>
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
	    if (confirm('確定要刪除此建築嗎？')) {
        //發送DELETE請求
        fetch('/delete_pm_and_pmdetail1/' + buildingId, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
        })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            // 刪除成功後可以重新載入頁面或者更新數據
            location.reload();
        })
        .catch((error) => {
            console.error('Error:', error);
        });
	     // 刪除成功後重新載入當前頁面
	    location.reload();
	    }

}




function creat(){
        // ターゲットURLを指定// 指定目標URL
        var targetUrl = '/creatPMmanager';
        // ページを指定のURLにリダイレクト// 將頁面重定向到指定的URL
        window.location.href = targetUrl;
}