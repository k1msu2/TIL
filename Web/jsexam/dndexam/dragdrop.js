var source, drop;
function initiate(){
  source=document.getElementById('image'); // <img>
  source.addEventListener('dragstart', dragged, false);

  drop=document.getElementById('dropbox');
  drop.addEventListener('dragover', function(e){console.log("dragover"); e.preventDefault(); }, false);
  //e.preventDefault(); 반드시 해제.
  drop.addEventListener('drop', dropped, false);
}
function dragged(e){
	console.log("dragstart");
  var code='<img src="'+source.getAttribute('src')+'">';
  e.dataTransfer.setData('Text', code);
}
function dropped(e){
	console.log("drop");
  e.preventDefault();
  drop.innerHTML=e.dataTransfer.getData('Text');
}
window.addEventListener('load', initiate);







