$(document).ready(function(){
    /*
     * Function check userName duplicate
     */
    function checkUserName(id) {
        var userName = $(id).val();
        userName = userName.trim();
        if (userName) {
            $.ajax({
                type: 'GET',
                url: contextPath+'/register.html?userName=' + userName,
                success: function (data) {
                    borderID(id, data);
                },
                error: function (data) {
                    borderID(id, data);
                }
            });
        }
    };

    /*
     * Function check email duplicate
     */
    function checkEmail(id) {
        var email = $(id).val();
        email = email.trim();
        if (email) {
            $.ajax({
                type: 'GET',
                url: contextPath+'/register.html?email=' + email,
                success: function (data) {
                    borderID(id, data);
                },
                error: function (data) {
                    borderID(id, data);
                }
            });
        }
    };

    /*
     * Function check userName duplicate
     */
    function checkPasswordStrong(id) {
        var pass = $(id).val();
        pass = pass.trim();
        if (pass) {
            if (pass.length < 8) {
                borderID(id, duplicateERROR);
            } else {
                borderID(id, duplicateOK);
            }
        }
    };
    
    // <editor-fold defaultstate="collapsed" desc="Event">
    $('#register-userName').blur(function(){
        checkUserName(this);
    });
    $('#register-email').blur(function(){
        checkEmail(this);
    });
    $('#register-password').keydown(function(){
        checkPasswordStrong(this);
    });
    // </editor-fold>
});