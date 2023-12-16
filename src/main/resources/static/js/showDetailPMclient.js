const currentPath = window.location.pathname;
const pmIdMatch = currentPath.match(/\d+/);

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


  