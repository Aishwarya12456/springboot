$(document).ready(function () {
    $("#registerForm").validate({
        rules: {
            fullName: {
                required: true,//meaning mandatory
                minlength: 3
            },
            email: {
                required: true,
                email: true
            },
            phone: {
                required: true,
                minlength: 10,
                maxlength: 10,
                digits: true
            },
            dob: {
                required: true,
                date: true
            }
        },
        messages: {
            fullName: {
                required: "Please enter full name",
                minlength: "Please enter atleast 3 characters"
            },
            email: {
                required: "Please enter email address",
                email: "Please enter valid email address"
            },
            phone: {
                required: "Please enter phone number",
                minlength: "Phone number must be 10 digits",
                maxlength: "Phone number must be 10 digits",
                digits: "Only numbers are allowed"
            },
            dob: {
                required: "Enter date of birth",
                date: "Enter valid date of birth"
            }
        },
        errorPlacement: function(error, element) {
            element.next().next().append(error);
        }
    })
})