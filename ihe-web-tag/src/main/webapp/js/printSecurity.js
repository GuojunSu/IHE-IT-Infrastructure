/*����k��  �]�bbody�]��
/ONDRAGSTART="window.event.returnValue=false" 
/ONCONTEXTMENU="window.event.returnValue=false" 
onSelectStart="event.returnValue=false"


*/

document.ondragstart = function () { 
    return false; 
}
document.oncontextmenu = function () { 
    return false; 
}
document.onselectstart = function () {
    return false; 
}

/*�������C�L
var onCtrl = 0;
var browser=navigator.appName;
if(browser=="Netscape"){
    document.captureEvents(Event.KEYDOWN);
    document.onkeydown=function(event){
        if(event.keyCode==17){
            onCtrl = 1;
            return true;
        } else if(event.keyCode==80 && onCtrl==1){
            alert("�ФŨϥμ���i������C�L!");
            onCtrl = 0;
            return false;
        }
    }
} else {
    document.onkeydown = function(){
        if(event.keyCode==17){
            onCtrl = 1;
            return true;
        } else if(event.keyCode==80 && onCtrl==1){
            alert("�ФŨϥμ���i������C�L!");
            onCtrl = 0;
            return false;
        }
    }
}*/
/*��L �ƹ� ��������*/
//document.onmousedown=click;
document.onkeydown=click;

/* 
 * document.layers == document.all
if (document.layers) {
    window.captureEvents(Event.MOUSEDOWN);
}
window.onmousedown=click;
*/
if (document.layers) {
    window.captureEvents(Event.KEYDOWN);
}
window.onkeydown=click;

function click(e){
    if (navigator.appName == 'Netscape'){
        if (e.which != 1){
            alert("you can't use mouse and keyboard !");     
            return false;
        }
    } else {
        //event.button 1.left 2.right
        if (event.button != 1) {
            alert("you can't use mouse and keyboard !");
            return false;
        }
    }
}

