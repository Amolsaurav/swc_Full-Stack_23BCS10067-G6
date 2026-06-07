const tabs = document.querySelectorAll('.tab');
const contents = document.querySelectorAll('.content');

tabs.forEach(tab => {

    tab.addEventListener("click", () => {

        tabs.forEach(btn => {
            btn.classList.remove("active");
        });

        contents.forEach(content => {
            content.classList.remove("active-content");
        });

        tab.classList.add("active");

        const targetId = tab.dataset.tab;

        document
            .getElementById(targetId)
            .classList.add("active-content");

    });

});