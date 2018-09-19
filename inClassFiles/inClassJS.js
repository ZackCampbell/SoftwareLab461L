function hide() {
    $("#text1")[0].style.display = "none";
}

function show() {
    $("#text1")[0].style.display = "block";
}

function format() {
    if ($("#text1")[0].style.display == "none")
        $("#text1")[0].setAttribute("style", "background-color: green; color: red; font-size: 20px; margin: auto; display: none;");
    else
        $("#text1")[0].setAttribute("style", "background-color: green; color: red; font-size: 20px; margin: auto; display: block;");
}

function reset() {
    $("#text1")[0].setAttribute("style", "background-color: white; color: black; font-size: 14px; text-align: left; display: block;");
}