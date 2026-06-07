const cards = document.querySelectorAll(".card");
const columns = document.querySelectorAll(".column");

let draggedCard = null;

cards.forEach(card => {

    card.addEventListener("dragstart", () => {
        draggedCard = card;
        card.classList.add("dragging");
    });

    card.addEventListener("dragend", () => {
        card.classList.remove("dragging");
    });

});

columns.forEach(column => {

    column.addEventListener("dragover", (e) => {
        e.preventDefault();
    });

    column.addEventListener("dragenter", () => {
        column.classList.add("drag-over");
    });

    column.addEventListener("dragleave", () => {
        column.classList.remove("drag-over");
    });

    column.addEventListener("drop", () => {

        column.appendChild(draggedCard);

        column.classList.remove("drag-over");
    });

});