function callAction(action) {
    window.location = action;
}
function toggleHidden(divId) {
    var theDiv = document.getElementById(divId);
    theDiv.style.display = (theDiv.style.display == 'block' ? 'none'
        : 'block');
    return false;
}