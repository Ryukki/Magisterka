class Quote{
    constructor(quoteText, quoteAuthor){
        this.quoteText = quoteText
        this.quoteAuthor = quoteAuthor
    }
}

var apiUrl = "http://localhost:8080"
var getRandomQuoteEndpoint = "/randomQuote"
var addQuoteEndpoint = "/addQuote"

var quoteTextDiv = document.getElementById('quoteTextDiv')
var quoteAuthorP = document.getElementById('quoteAuthorP')
var quote
function getRandomQuote(){
    requestQuote()
}

const requestQuote = async() => {
    let response = await fetch(apiUrl + getRandomQuoteEndpoint)
    if(handleErrors(response)){
        quote = await response.json()
        displayQuote()
    }
}

function handleErrors(response) {
    if (!response.ok) {
        alert("API request returned: " + response.status + " " + response.statusText);
        return false
    }
    return true
}

const displayQuote = async() => {
    quoteTextDiv.innerHTML = "<h1><b><i>&quot;" + quote.quoteText + "&quot;</h1></b></i>"
    quoteAuthorP.innerHTML = "<h3>" + quote.quoteAuthor + "</h3>"
}