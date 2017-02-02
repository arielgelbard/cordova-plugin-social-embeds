#import <Cordova/CDV.h>

@interface HWPHello : CDVPlugin
@property (nonatomic, assign) BOOL flag;
@property NSMutableArray *whiteList;
- (void) greet:(CDVInvokedUrlCommand*)command;

@end
