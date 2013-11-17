#import <Cordova/CDV.h>

@interface Insomnia :CDVPlugin

- (void) keepAwake:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;

- (void) allowSleepAgain:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;

@end
