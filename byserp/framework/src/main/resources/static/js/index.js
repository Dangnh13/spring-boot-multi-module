if ("serviceWorker" in navigator) {
  window.addEventListener("load", function() {
    navigator.serviceWorker
        .register("/auth/js/sw.js")
        .then(res => console.log("service worker registered"))
        .catch(err => console.log("service worker not registered", err));
  });
}

let deferredPrompt;

window.addEventListener('beforeinstallprompt', (e) => {
  // Prevent the mini-infobar from appearing on mobile
  e.preventDefault();
  // Stash the event so it can be triggered later.
  deferredPrompt = e;
  // Update UI notify the user they can install the PWA
  showInstallPromotion();
});

window.addEventListener('appinstalled', (evt) => {
  // Log install to analytics
  console.log('INSTALL: Success');
});