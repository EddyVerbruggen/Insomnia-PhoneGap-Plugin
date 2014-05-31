
using System;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Documents;
using System.Windows.Ink;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Shapes;
using Microsoft.Phone.Info;
using System.IO.IsolatedStorage;
using System.Windows.Resources;


namespace WPCordovaClassLib.Cordova.Commands
{
    public class Insomnia : BaseCommand
    {

        public void keepAwake(string options) 
        {
            PhoneApplicationService.Current.UserIdleDetectionMode = IdleDetectionMode.Disabled;
            DispatchCommandResult(new PluginResult(PluginResult.Status.OK));
        }

        public void allowSleepAgain(string options) 
        {
            PhoneApplicationService.Current.UserIdleDetectionMode = IdleDetectionMode.Disabled; //??
            DispatchCommandResult(new PluginResult(PluginResult.Status.OK));
        }
    }
}
