$(function () {


$('.slideshow div:first').fadeIn(1000);

setInterval(function() {
  $('.slideshow > div:first')
    .fadeOut(1000)
    .next()
    .fadeIn(1000)
    .end()
    .appendTo('.slideshow');
},  9000);

});