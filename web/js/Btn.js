/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */


function MostrarCD(){
    document.getElementById("subir_txt").style.display="none";
    document.getElementById("btn_cifrar").style.display="block";
    document.getElementById("btn_decifrar").style.display="block";
}
function MostrarEC(){
    document.getElementById("btn_decifrar").style.display="none";
    document.getElementById("btn_cifrar").style.display="none";
    document.getElementById("btn_cifrar").value = "true";
}
