// var chartTemperatura, chartHumedad;
// var dataTemperatura = [], dataHumedad = [];
// var ejeXTemperatura = [], ejeXHumedad = [];
// var webSocket;
//var tiempoReconectar = 5000;

$(document).ready(function () {
    loadSavedTable()
  //  grafico1();
    // grafico2();
});


function loadSavedTable() {
    $.ajax({
        url: '/rest/instancias',
        async: false,
        success: function (response) {
            console.log(response);
        }
    });

}

//
// function grafico1() {
//
//     var option;
//     option = {
//         title: {
//             text: 'Temperatura'
//         },
//         tooltip: {
//             trigger: 'axis',
//             // formatter: function (params) {
//             //
//             //     // console.log(params);
//             //     return params[0].axisValue + ' ' + params[0].value[1];
//             // }
//
//
//         },
//         xAxis: {
//             type: 'category',
//             data: ejeXTemperatura,
//             splitLine: {
//                 show: false
//             }
//         },
//         yAxis: {
//             type: 'value',
//             boundaryGap: [0, '100%'],
//             splitLine: {
//                 show: false
//             }
//         },
//         series: [{
//             data: [0],
//             type: 'line',
//             hoverAnimation: false,
//         }],
//         color: ['rgb(102,0,153)'],
//
//
//     };
//
//     chartTemperatura = echarts.init(document.getElementById("chart"));
//     chartTemperatura.setOption(option);
//
// }
//
// function grafico2() {
//
//     var option;
//     option = {
//         title: {
//             text: 'Humedad'
//         },
//         tooltip: {
//             trigger: 'axis',
//
//
//         },
//         xAxis: {
//             type: 'category',
//             data: ejeXHumedad,
//             splitLine: {
//                 show: false
//             }
//         },
//         yAxis: {
//             type: 'value',
//             boundaryGap: [0, '100%'],
//             splitLine: {
//                 show: false
//             }
//         },
//         series: [{
//             data: [0],
//             type: 'line',
//             hoverAnimation: false,
//         }],
//         color: ['rgb(0,77,230)'],
//
//
//     };
//
//     chartHumedad = echarts.init(document.getElementById("humedad"));
//     chartHumedad.setOption(option);
//
// }
//
// function nuevoValor(datos) {
//
//     var nuevo = JSON.parse(datos);
//     // console.log(nuevo);
//     // data.shift();
//     dataTemperatura.push(nuevo.temperatura);
//     dataHumedad.push(nuevo.humedad);
//
//     // ejeX.shift();
//     ejeXTemperatura.push(nuevo.fecha);
//     ejeXHumedad.push(nuevo.fecha);
//
//     chartTemperatura.setOption({
//         xAxis: {
//             data: ejeXTemperatura
//         },
//
//         series: [{
//             data: dataTemperatura
//         }]
//
//     });
//
//     chartHumedad.setOption({
//         xAxis: {
//             data: ejeXHumedad
//         },
//
//         series: [{
//             data: dataHumedad
//         }]
//
//     });
// }
//
//
// function conectar() {
//     webSocket = new WebSocket("ws://" + location.hostname + ":" + location.port + "/nuevoMensaje");
//     webSocket.onmessage = function (datos) {
//         // console.log(datos);
//         nuevoValor(datos.data);
//     };
// }
//
// function verificarConexion() {
//     if (!webSocket || webSocket.readyState === 3) {
//         conectar();
//     }
// }
//
// setInterval(verificarConexion, tiempoReconectar);