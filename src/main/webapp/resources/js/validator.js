function validNumberKey(evt) {
    var keyCode = (evt.which) ? evt.which : evt.keyCode;
    if (keyCode > 31 && (keyCode < 48 || keyCode > 57))
    {
        if (keyCode == 37 || keyCode == 39)
            return true;
        return false;
    }
    return true;
}