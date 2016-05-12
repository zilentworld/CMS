/**
 * Created by dev-pc on 5/11/16.
 */
function callAction(action) {
    window.location = action;
}
function toggleHidden(divId) {
    var theDiv = document.getElementById(divId);
    theDiv.style.display = (theDiv.style.display == 'block' ? 'none'
        : 'block');
    return false;
}
