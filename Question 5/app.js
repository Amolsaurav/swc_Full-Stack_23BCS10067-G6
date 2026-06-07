const list = document.getElementById("list");

for(let i = 1; i <= 1000; i++){

    const item = document.createElement("div");

    item.className = "item";

    item.innerHTML = `
        <span>Product ${i}</span>
        <button class="delete-btn">Delete</button>
    `;

    list.appendChild(item);
}

list.addEventListener("click", function(event){

    if(event.target.classList.contains("delete-btn")){

        const itemToDelete = event.target.parentElement;

        itemToDelete.remove();
    }

});