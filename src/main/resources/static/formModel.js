const formInputsCont = document.getElementById("formInputsCont")
const formInputs = formInputsCont.querySelectorAll("input")
const formInputErrors = formInputs.querySelectorAll("p2")

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