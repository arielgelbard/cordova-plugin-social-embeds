#import "HWPHello.h"

@implementation HWPHello

-(id)init {
    if ( self = [super init] ) {
        self.flag = false;
    }
    return self;
}

- (void)greet:(CDVInvokedUrlCommand*)command
{
    NSString* name = [[command arguments] objectAtIndex:0];

    if([name isEqualToString:@""]){
        NSLog(@"Plugin is disabled - - - - - - -");
        self.flag = false;
    } else {
        NSLog(@"Plugin is enabled - - - - - - -");
        self.flag = true;
        self.whiteList = [[name componentsSeparatedByString: @","] mutableCopy];
    }

    CDVPluginResult* result = [CDVPluginResult
                               resultWithStatus:CDVCommandStatus_OK
                               messageAsString:@"success"];
    [self.commandDelegate sendPluginResult:result callbackId:command.callbackId];
}

- (BOOL)shouldOverrideLoadWithRequest:(NSURLRequest*)request navigationType:(UIWebViewNavigationType)navigationType
{
    BOOL allowNavigationsPass = true;

    NSURL* url = [request URL];
    if(self.flag) {
        for (NSString *whiteListUrl in self.whiteList) {
            if ([[url.absoluteString lowercaseString] containsString:[whiteListUrl lowercaseString]]) {
                allowNavigationsPass = NO;
                [self.commandDelegate evalJs:[NSString stringWithFormat:@"window.openLinkInAppBrowser('%@');", url.absoluteString]];
                break;
            }
        }
    } else {
        allowNavigationsPass = YES;
    }

    return allowNavigationsPass;
}

@end
