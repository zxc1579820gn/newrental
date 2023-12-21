const currentPath = window.location.pathname;
const pmIdMatch = currentPath.match(/\d+/);
// 在全局范围定义一个数组，用于存储已选的路线
var selectedLines = [];
// 在全局范围定义一个数组，用于存储已选的車站
var selectedStation = [];

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
            //將值傳入的lineName和stationName拆分为数组存入全域變數
			selectedLines = data.lineName.split(',');
			selectedStation = data.stationName.split(',');
            // 填充页面的lineName和stationName
            document.getElementById('lineName').innerText ="lineName: "+data.lineName;
            document.getElementById('stationName').innerText ="stationName: "+data.stationName;
			// 填充页面的输入字段
			//名 称
            document.getElementById('building-name').value = data.buildingName;
            // 棟
            document.getElementById('building-tower').value = data.buildingTower;
            //階
            document.getElementById('building-floor').value = data.buildingFloor;
            //号室
            document.getElementById('building-room').value = data.buildingRoom;
			//住居表示
            document.getElementById('residence-address').value = data.residenceAddress;
            //登記簿
            document.getElementById('registration-record').value = data.registrationRecord;
            //種 類
            document.getElementById('building-structure').value = data.buildingStructure;
            //戸 数
            document.getElementById('number-of-units').value = data.numberOfUnits;
            //建築時期
            document.getElementById('year').value = data.constructionYear;
            //大規模修繕を
            document.getElementById('big-construction-date-year').value=data.bigConstructionDate;
            //住戸番号
            document.getElementById('unit-number').value = data.unitNumber;
            //間取り
            document.getElementById('layout').value = data.layout;
            //床 面 積
            document.getElementById('floor-area').value = data.floorArea;
            // 其他床 面 積
            document.getElementById('floor-area2').value = data.otherFloorArea; 
//==================================================LOAD 住戸部分の設備===========================================================            
			//電気            
			document.querySelector('input[name="electricity"][value="' + data.electricity + '"]').checked = true;
			document.getElementById('electricity-context').value = data.electricityContext;
			document.getElementById('electricity-remarks').value = data.electricityRemarks;
			//ガス
			document.querySelector('input[name="gas"][value="' + data.gas + '"]').checked = true;
			document.getElementById('gas-context').value = data.gasContext;
			document.getElementById('gas-remarks').value = data.gasRemarks;
			//コンロ
			document.querySelector('input[name="stove"][value="' + data.stoveValue + '"]').checked = true;
			document.getElementById('stove-context').value = data.stoveContext;
			document.getElementById('stove-remarks').value = data.stoveRemarks;
			//上水道
			document.querySelector('input[name="water-supply"][value="' + data.waterSupplyValue + '"]').checked = true;
			document.getElementById('water-supply-context').value = data.waterSupplyContext;
			document.getElementById('water-supply-remarks').value = data.waterSupplyRemarks;
			////下水道
			document.querySelector('input[name="sewerage"][value="' + data.sewerageValue + '"]').checked = true;
			document.getElementById('sewerage-context').value = data.sewerageContext;
			document.getElementById('sewerage-remarks').value = data.sewerageRemarks;
			//// 台所
			document.querySelector('input[name="kitchen"][value="' + data.kitchenValue + '"]').checked = true;
			document.getElementById('kitchen-context').value = data.kitchenContext;
			document.getElementById('kitchen-remarks').value = data.kitchenRemarks;
			//トイレ
			document.querySelector('input[name="toilet"][value="' + data.toiletValue + '"]').checked = true;
			document.getElementById('toilet-context').value = data.toiletContext;
			document.getElementById('toilet-remarks').value = data.toiletRemarks;
			// 浴室
			document.querySelector('input[name="bathroom"][value="' + data.bathroomValue + '"]').checked = true;
			document.getElementById('bathroom-context').value = data.bathroomContext;
			document.getElementById('bathroom-remarks').value = data.bathroomRemarks;
			// 洗面台
			document.querySelector('input[name="washbasin"][value="' + data.washbasinValue + '"]').checked = true;
			document.getElementById('washbasin-context').value = data.washbasinContext;
			document.getElementById('washbasin-remarks').value = data.washbasinRemarks;
			// 洗濯機置場
			document.querySelector('input[name="laundry-area"][value="' + data.laundryAreaValue + '"]').checked = true;
			document.getElementById('laundry-area-context').value = data.laundryAreaContext;
			document.getElementById('laundry-area-remarks').value = data.laundryAreaRemarks;
			// 給湯設備
			document.querySelector('input[name="water-heater"][value="' + data.waterHeaterValue + '"]').checked = true;
			document.getElementById('water-heater-context').value = data.waterHeaterContext;
			document.getElementById('water-heater-remarks').value = data.waterHeaterRemarks;
			// 冷暖房設備（エアコン）
			document.querySelector('input[name="air-conditioner"][value="' + data.airConditionerValue + '"]').checked = true;
			document.getElementById('air-conditioner-context').value = data.airConditionerContext;
			document.getElementById('air-conditioner-remarks').value = data.airConditionerRemarks;
			// 照明器具
			document.querySelector('input[name="lighting"][value="' + data.lightingValue + '"]').checked = true; // 根据值设置选中状态
			document.getElementById('lighting-context').value = data.lightingContext; // 设置输入框的值
			document.getElementById('lighting-remarks').value = data.lightingRemarks; // 设置输入框的值
			// 備付家具
			document.querySelector('input[name="furniture"][value="' + data.furnitureValue + '"]').checked = true;
			document.getElementById('furniture-context').value = data.furnitureContext;
			document.getElementById('furniture-remarks').value = data.furnitureRemarks;
			// 地デジ対応
			document.querySelector('input[name="digital-tv"][value="' + data.digitalTvValue + '"]').checked = true;
			document.getElementById('digital-tv-context').value = data.digitalTvContext;
			document.getElementById('digital-tv-remarks').value = data.digitalTvRemarks;
			// CATV対応
			document.querySelector('input[name="catv"][value="' + data.catvValue + '"]').checked = true;
			document.getElementById('catv-context').value = data.catvContext;
			document.getElementById('catv-remarks').value = data.catvRemarks;
			// インターネット
			document.querySelector('input[name="internet"][value="' + data.internetValue + '"]').checked = true;
			document.getElementById('internet-context').value = data.internetContext;
			document.getElementById('internet-remarks').value = data.internetRemarks;
			// トランクルーム
			document.querySelector('input[name="trunk-room"][value="' + data.trunkRoom + '"]').checked = true;
			document.getElementById('trunk-room-context').value = data.trunkRoomContext;
			document.getElementById('trunk-room-remarks').value = data.trunkRoomRemarks;
			// 専用庭
			document.querySelector('input[name="private-garden"][value="' + data.privateGarden + '"]').checked = true;
			document.getElementById('private-garden-context').value = data.privateGardenContext;
			document.getElementById('private-garden-remarks').value = data.privateGardenRemarks;
			// ルーフバルコニー
			document.querySelector('input[name="roof-balcony"][value="' + data.roofBalcony + '"]').checked = true;
			document.getElementById('roof-balcony-context').value = data.roofBalconyContext;
			document.getElementById('roof-balcony-remarks').value = data.roofBalconyRemarks;
			// 鍵
			document.querySelector('input[name="key"][value="' + data.keyValue + '"]').checked = true;
			document.getElementById('key-context').value = data.keyContext;
			document.getElementById('key-remarks').value = data.keyRemarks;
//================================================LOAD 共用部分の設備・施設=====================================================			
			// エレベーター
			document.querySelector('input[name="elevator"][value="' + data.elevatorValue + '"]').checked = true;
			document.getElementById('elevator-context').value = data.elevatorContext;
			document.getElementById('elevator-remarks').value = data.elevatorRemarks;
			// オートロック
			document.querySelector('input[name="auto-lock"][value="' + data.autoLockValue + '"]').checked = true;
			document.getElementById('auto-lock-context').value = data.autoLockContext;
			document.getElementById('auto-lock-remarks').value = data.autoLockRemarks;
			// メールボックス
			document.querySelector('input[name="mailbox"][value="' + data.mailboxValue + '"]').checked = true;
			document.getElementById('mailbox-context').value = data.mailboxContext;
			document.getElementById('mailbox-remarks').value = data.mailboxRemarks;
			// 宅配ボックス
			document.querySelector('input[name="delivery-box"][value="' + data.deliveryBoxValue + '"]').checked = true;
			document.getElementById('delivery-box-context').value = data.deliveryBoxContext;
			document.getElementById('delivery-box-remarks').value = data.deliveryBoxRemarks;
			// トランクルーム
	        document.querySelector('input[name="storage-room"][value="' + data.storageRoom + '"]').checked = true;
	        document.getElementById('storage-room-context').value = data.storageRoomContext;
	        document.getElementById('storage-room-remarks').value = data.storageRoomRemarks;
	        // 駐車場
	        document.querySelector('input[name="parking"][value="' + data.parking + '"]').checked = true;
	        document.getElementById('parking-context').value = data.parkingContext;
	        document.getElementById('parking-remarks').value = data.parkingRemarks;
	        // 駐輪場
	        document.querySelector('input[name="bike-parking"][value="' + data.bikeParking + '"]').checked = true;
	        document.getElementById('bike-parking-context').value = data.bikeParkingContext;
	        document.getElementById('bike-parking-remarks').value = data.bikeParkingRemarks;
	        // バイク置場
	        document.querySelector('input[name="motorcycle-parking"][value="' + data.motorcycleParking + '"]').checked = true;
	        document.getElementById('motorcycle-parking-context').value = data.motorcycleParkingContext;
	        document.getElementById('motorcycle-parking-remarks').value = data.motorcycleParkingRemarks;
//=================================================LOAD 契約期間========================================================
		    // 契約始期
	        document.getElementById('contract-start-date').value = data.contractStartDate;
	        // 契約終期
	        document.getElementById('contract-end-date').value = data.contractEndDate;
	        // 合計契約時間
	        document.getElementById('total-contract-duration').value = data.totalContractDuration;
	        // 目的物件の引渡日
	        document.getElementById('property-delivery-date').value = data.propertyDeliveryDate;
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
//====================================LOAD Lines And Station==========================================
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
//===========================================LOAD buildingType (表示选中的建筑类型)========================================
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

//====================================Add Lines And Station==========================================
// 添加Liin和Station按钮的通用函数
function addButton(value, container, array) {
    var button = document.createElement('button');
    button.textContent = value;
    button.value= value;
    // 根据数组类型设置不同的class
    if (array === selectedLines) {
        button.className = 'AreaBtn3';
    } else if (array === selectedStation) {
        button.className = 'AreaBtn';
    }
    // 添加点击事件处理程序
    button.addEventListener('click', function () {
		console.log('btn click:', value);
    });
    // 将按钮添加到容器中
    container.appendChild(button);
}



















  