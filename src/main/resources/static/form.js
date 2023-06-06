const formInputsCont = document.getElementById("formInputsCont")
const formInputs = formInputsCont.querySelectorAll("input")
const formInputErrors = formInputsCont.querySelectorAll("p2")
const clearButton = document.getElementById("clearButton")
const addButton = document.getElementById("addButton")

const nameTextBoxId = "nameTextBox"
const heightTextBoxId = "heightTextBox"
const weightTextBoxId = "weightTextBox"
const hairTextBoxId = "hairTextBox"
const gpaTextBoxId = "gpaTextBox"

const nameErrorId = "nameError"
const heightErrorId = "heightError"
const weightErrorId = "weightError"
const hairError = "hairErorr"
const gpaError = "gpaError"

const textBoxToErrorId  = {
    [nameTextBoxId]: nameErrorId,
    [heightTextBoxId]: heightErrorId,
    [weightTextBoxId]: weightErrorId,
    [hairError]: hairError,
    [gpaTextBoxId]: gpaError,
}

var formModel = {
    [nameTextBoxId]: String,
    [heightTextBoxId]: Number,
    [weightTextBoxId]: Number,
    [hairError]: String,
    [gpaTextBoxId]: Number,
}

clearButton.addEventListener("click", function() {
    formInputs.forEach(function(formInputs) {
        formInputs.value = ""
    })
})