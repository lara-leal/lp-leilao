# Exemplos de requisição para teste:

## 1. Client

 ````
  {
    "name": "lara",
    "email": "lara.o.leal@hotmail.com",
    "cpf": "47899446899",
    "digitalCertificate": "934849"
  }
````

## 2. Financial Institution

 ````
{
  "cnpj": "34877758748943",
  "name": "ITAU",
  "address": "Avenida Salmão 234"
}

````

## 3. Auction

Em "category" escolher: DEVICE, VEHICLE ou BOTH

Vehicles:
````
{
  "numAuction": 1,
  "status": "OPEN",
  "occurrenceDate": "2023-11-19T21:34:52.810Z",
  "finishDate": "2023-11-19T21:34:52.810Z",
  "visitDate": "2023-11-19T21:34:52.810Z",
  "address": "Rua Saitama 384",
  "category": "VEHICLE",
  "fInstitutions": [
    {
      "fiid": 1
    }
  ],
  "product": {}
}
````
Devices:
````
{
  "numAuction": 2,
  "status": "OPEN",
  "occurrenceDate": "2023-11-19T21:34:52.810Z",
  "finishDate": "2023-11-19T21:34:52.810Z",
  "visitDate": "2023-11-19T21:34:52.810Z",
  "address": "Rua Saitama 384",
  "category": "DEVICE",
  "fInstitutions": [
    {
      "fiid": 1
    }
  ],
  "product": {}
}
````
**Obs**: Não é preciso passar o product


## 4.  Vehicles
Cars:
````
{
  "brand": "Toyota",
  "manufactureYear": "2022",
  "model": "Camry",
  "description": "A reliable and fuel-efficient sedan.",
  "type": "car",
  "color": "Silver",
  "initialValue": 25000,
  "category": "VEHICLE",
  "yearLicensing": 2023,
  "resultPrecautionaryExpertise": "No issues reported",
  "tractionType": "Front-wheel drive",
  "sunroof": true,
  "productId": 1
}
````
Motorcycle:

````
{
  "brand": "Harley-Davidson",
  "manufactureYear": "2021",
  "model": "Street Glide",
  "description": "A powerful cruiser motorcycle with a comfortable ride.",
  "type": "motorcycle",
  "color": "Black",
  "initialValue": 18000,
  "category": "VEHICLE",
  "yearLicensing": 2022,
  "resultPrecautionaryExpertise": "No issues reported",
  "tractionType": "Belt drive",
  "productId": 1
}
````

Trucks:

````
{
  "brand": "Volvo",
  "manufactureYear": "2020",
  "model": "VNL 860",
  "description": "A reliable long-haul truck with advanced safety features.",
  "type": "truck",
  "color": "Blue",
  "initialValue": 80000,
  "category": "VEHICLE",
  "yearLicensing": 2021,
  "resultPrecautionaryExpertise": "Passed safety inspections",
  "tractionType": "Rear-wheel drive",
  "productId": 1
}

````

Bus:

```
{
  "brand": "Mercedes-Benz",
  "manufactureYear": "2019",
  "model": "Sprinter",
  "description": "A comfortable and spacious passenger bus.",
  "type": "bus",
  "color": "White",
  "initialValue": 55000,
  "category": "VEHICLE",
  "yearLicensing": 2020,
  "resultPrecautionaryExpertise": "Serviced regularly",
  "tractionType": "Rear-wheel drive",
  "productId": 1
}



```

Van:

````
{
  "brand": "Mercedes-Benz",
  "manufactureYear": "2019",
  "model": "Sprinter",
  "description": "A comfortable and spacious passenger bus.",
  "type": "bus",
  "color": "White",
  "initialValue": 55000,
  "category": "VEHICLE",
  "yearLicensing": 2020,
  "resultPrecautionaryExpertise": "Serviced regularly",
  "tractionType": "Rear-wheel drive",
  "productId": 1
}
````

## 5. Devices

Notebooks:
````
{
  "name": "Notebook ABC",
  "quantity": 5,
  "category": "DEVICE",
  "type": "notebook",
  "description": "Powerful laptop for business and personal use.",
  "brand": "XYZ",
  "initialValue": 1200,
  "ports": "USB, HDMI",
  "productSpecification": "Intel Core i7, 16GB RAM, 512GB SSD",
  "screenSize": "15.6 inches",
  "antenna": false,
  "productId": 2
}

````
Monitors:
````
{
  "name": "HD Monitor",
  "quantity": 8,
  "category": "DEVICE",
  "type": "monitor",
  "description": "Crystal-clear display for enhanced productivity.",
  "brand": "ViewSonic",
  "initialValue": 300,
  "ports": "HDMI, DisplayPort",
  "productSpecification": "1920x1080 resolution",
  "screenSize": "24 inches",
  "antenna": false,
  "productId": 2
}

````
Hubs:
````
{
  "name": "USB Hub",
  "quantity": 10,
  "category": "DEVICE",
  "type": "hub",
  "description": "Expand your connectivity with this USB hub.",
  "brand": "TechHub",
  "initialValue": 30,
  "ports": "4 USB ports",
  "productSpecification": "USB 3.0",
  "screenSize": null,
  "antenna": false,
  "productId": 2
}

````
Routers:
````
{
  "name": "High-Speed Router",
  "quantity": 3,
  "category": "DEVICE",
  "type": "router",
  "description": "Ensure fast and reliable internet with this router.",
  "brand": "NetLink",
  "initialValue": 80,
  "ports": "4 LAN ports, 1 WAN port",
  "productSpecification": "Dual-band, 802.11ac",
  "screenSize": null,
  "antenna": true,
  "productId": 2
}


````
Switches:

````
{
  "name": "Ethernet Switch",
  "quantity": 6,
  "category": "DEVICE",
  "type": "switche",
  "description": "Expand your network with this reliable switch.",
  "brand": "LinkSys",
  "initialValue": 50,
  "ports": "8 Ethernet ports",
  "productSpecification": "Gigabit switch",
  "screenSize": null,
  "antenna": false,
  "productId": 2
}

````



## 6. Bids
````
{
  "bidValue": 4000000,
  "date": "2023-11-19T23:02:44.083Z",
  "bidCategory": "string",
  "productIdSale": 1,
  "winner": true,
  "client": {
    "name": "lara",
    "email": "lara.o.leal@hotmail.com",
    "cpf": "47899446899",
    "digitalCertificate": "934849"
  }
}
````
# OBS: O relatório extraído está sendo salvo na pasta target.
