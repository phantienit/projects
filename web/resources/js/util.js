/*
 * Toastr Message Show
 */
function resultMessage_show(success, message) {
    if (success == 1) {
        toastr.success(message, '', {
            "positionClass": "toast-bottom-right",
            "closeButton": true,
            "debug": false,
            "newestOnTop": false,
            "progressBar": false,
            "preventDuplicates": false,
            "onclick": null,
            "showDuration": "300",
            "hideDuration": "1000",
            "timeOut": "5000",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"
        });
    } else {
        toastr.error(message, '', {
            "positionClass": "toast-bottom-right",
            "closeButton": true,
            "debug": false,
            "newestOnTop": false,
            "progressBar": false,
            "preventDuplicates": false,
            "onclick": null,
            "showDuration": "300",
            "hideDuration": "1000",
            "timeOut": "5000",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"
        });
    }
    return true;
};

/*
 * 0: Error
 * 1: OK
 */
function borderID(id, type) {
    if (type == duplicateERROR) {
        $(id).removeClass('boder-correct');
        $(id).addClass('boder-incorrect');
    }
    else if (type == duplicateOK) {
        $(id).removeClass('boder-incorrect');
        $(id).addClass('boder-correct');
    }
    return true;
};