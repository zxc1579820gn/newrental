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
                    <td><button onclick="handleButtonClick(${building.id})">物件情報</button></td>
                `;
                tableBody.appendChild(row);
            });
    })
    .catch(error => {
        console.error('Error:', error);
    });
//=================================================================================================================    

//物件情報BTN
function handleButtonClick(buildingId) {
    // 使用 Thymeleaf 的语法构建 URL
    const url = '/showDetailPMclient/' + buildingId; // 注意这里使用了 Thymeleaf 的语法
    // 执行页面跳转
    window.location.href = url;
}
    
    
    