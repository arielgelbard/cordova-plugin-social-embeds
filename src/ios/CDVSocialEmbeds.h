#import <Cordova/CDV.h>

@interface CDVSocialEmbeds : CDVPlugin
@property (nonatomic, assign) BOOL flag;
@property NSMutableArray *whiteList;
- (void) updatePluginToWhitelist:(CDVInvokedUrlCommand*)command;

@end
