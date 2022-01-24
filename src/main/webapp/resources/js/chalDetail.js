/*!
* Start Bootstrap - Shop Item v5.0.4 (https://startbootstrap.com/template/shop-item)
* Copyright 2013-2021 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-shop-item/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project

document.addEventListener('DOMContentLoaded', () => {

    // Unix timestamp (in seconds) to count down to
    var twoDaysFromNow = (new Date().getTime() / 1000) + (86400 * 2) + 1;
  
    // Set up FlipDown
    var flipdown = new FlipDown(twoDaysFromNow)
  
      // Start the countdown
      .start()
  
      // Do something when the countdown ends
      .ifEnded(() => {
        console.log('The countdown has ended!');
      });
  
    // Toggle theme
    var interval = setInterval(() => {
      let body = document.body;
      body.classList.toggle('light-theme');
      body.querySelector('#flipdown').classList.toggle('flipdown__theme-dark');
      body.querySelector('#flipdown').classList.toggle('flipdown__theme-light');
    }, 5000);
    
    var ver = document.getElementById('ver');
    ver.innerHTML = flipdown.version;
  });