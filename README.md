# Cordova Social Embed Plugin

This plugin will call javascript function defined in your app when user click on any iFrame links. Will solve the issues of instagram and twitter embeds if used properly.

## version
0.0.1

## Using

Install the plugin

    $ cordova plugin add cordova-plugin-inappbrowser
    $ cordova plugin add https://jagraj47@bitbucket.org/jagraj47/cordova-plugin-social-embeds.git


Edit `index.html` and add the following code

```js
    <script>
        window.openLinkInAppBrowser = function (url) {
               console.log('Linked click  - ', url);
               window.open(url, '_blank');
        }
    </script>
```

Use following code in your component where loading embeds

```js
    declare const SocialEmbeds; // In case you are getting typescript errorMessage
    // Enable plugin
    SocialEmbeds.updatePluginToWhitelist('url1,ur2,url3,...', function(success){}, function(failure){});
    // Disable plugin
    SocialEmbeds.updatePluginToWhitelist('', function(success){}, function(failure){});
```
