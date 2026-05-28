const textarea = document.getElementById('inputText');
const charCount = document.getElementById('charCount');
const button = document.getElementById('submit-btn');

textarea.addEventListener('input',()=>{
    const text = textarea.value.trim();
    let count = text.length;
    charCount.textContent = `${text.length}/${textarea.maxLength}`;

    if(count < 160){
        textarea.style.backgroundColor = '#e9e9e9f5';
        button.disabled=true;
    }else if(count >160 && count <= 180){
        textarea.style.backgroundColor = '#af4811f5'
        button.disabled=true;
    }
    else if(count >=195 && count < 200){
        textarea.style.backgroundColor = '#e90000f5'
        button.disabled=true;
    }
    else button.disabled=false;
})