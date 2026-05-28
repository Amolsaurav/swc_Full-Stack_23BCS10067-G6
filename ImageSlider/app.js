const slider = document.getElementById('slider');
const leftArrow = document.querySelector('.fa-arrow-circle-left');
const rightArrow = document.querySelector('.fa-arrow-circle-right');
const images = [
    'https://shorturl.at/rZkCT',
    'https://shorturl.at/YSKCI',
    'https://shorturl.at/9WLQu',
    'https://rukminim2.flixcart.com/fk-p-flap/2000/980/image/8b013ccade9f153d.jpg?q=60',
    'https://shorturl.at/hkRSs',
    'https://shorturl.at/tCraQ'
];
let currentIndex = 0;
slider.src = images[currentIndex];

function showImage(index) {
    slider.src = images[index];
}

leftArrow.addEventListener('click', () => {
    currentIndex = (currentIndex - 1 + images.length) % images.length;
    showImage(currentIndex);
});

rightArrow.addEventListener('click', () => {
    currentIndex = (currentIndex + 1) % images.length;
    showImage(currentIndex);
});

showImage(currentIndex);


let autoSlide = setInterval(()=>{
    currentIndex = (currentIndex + 1) % images.length;
    showImage(currentIndex);
}, 3000);

slider.addEventListener('mouseover',()=>{
    clearInterval(autoSlide);
});

slider.addEventListener('mouseout',()=>{
    autoSlide = setInterval(()=>{
        currentIndex = (currentIndex + 1) % images.length;
        showImage(currentIndex);
    }, 3000);
});

