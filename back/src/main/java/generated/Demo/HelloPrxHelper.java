// **********************************************************************
//
// Copyright (c) 2003-2015 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.6.0
//
// <auto-generated>
//
// Generated from file `Hello.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package generated.Demo;

public final class HelloPrxHelper extends Ice.ObjectPrxHelperBase implements HelloPrx
{
    private static final String __sayHello_name = "sayHello";

    public String sayHello(int delay)
    {
        return sayHello(delay, null, false);
    }

    public String sayHello(int delay, java.util.Map<String, String> __ctx)
    {
        return sayHello(delay, __ctx, true);
    }

    private String sayHello(int delay, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        __checkTwowayOnly(__sayHello_name);
        return end_sayHello(begin_sayHello(delay, __ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_sayHello(int delay)
    {
        return begin_sayHello(delay, null, false, false, null);
    }

    public Ice.AsyncResult begin_sayHello(int delay, java.util.Map<String, String> __ctx)
    {
        return begin_sayHello(delay, __ctx, true, false, null);
    }

    public Ice.AsyncResult begin_sayHello(int delay, Ice.Callback __cb)
    {
        return begin_sayHello(delay, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_sayHello(int delay, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_sayHello(delay, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_sayHello(int delay, Callback_Hello_sayHello __cb)
    {
        return begin_sayHello(delay, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_sayHello(int delay, java.util.Map<String, String> __ctx, Callback_Hello_sayHello __cb)
    {
        return begin_sayHello(delay, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_sayHello(int delay, 
                                          IceInternal.Functional_GenericCallback1<String> __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_sayHello(delay, null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_sayHello(int delay, 
                                          IceInternal.Functional_GenericCallback1<String> __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                          IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_sayHello(delay, null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_sayHello(int delay, 
                                          java.util.Map<String, String> __ctx, 
                                          IceInternal.Functional_GenericCallback1<String> __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_sayHello(delay, __ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_sayHello(int delay, 
                                          java.util.Map<String, String> __ctx, 
                                          IceInternal.Functional_GenericCallback1<String> __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                          IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_sayHello(delay, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_sayHello(int delay, 
                                           java.util.Map<String, String> __ctx, 
                                           boolean __explicitCtx, 
                                           boolean __synchronous, 
                                           IceInternal.Functional_GenericCallback1<String> __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                           IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_sayHello(delay, __ctx, __explicitCtx, __synchronous, 
                              new IceInternal.Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb)
                                  {
                                      public final void __completed(Ice.AsyncResult __result)
                                      {
                                          HelloPrxHelper.__sayHello_completed(this, __result);
                                      }
                                  });
    }

    private Ice.AsyncResult begin_sayHello(int delay, 
                                           java.util.Map<String, String> __ctx, 
                                           boolean __explicitCtx, 
                                           boolean __synchronous, 
                                           IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__sayHello_name);
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__sayHello_name, __cb);
        try
        {
            __result.prepare(__sayHello_name, Ice.OperationMode.Idempotent, __ctx, __explicitCtx, __synchronous);
            IceInternal.BasicStream __os = __result.startWriteParams(Ice.FormatType.DefaultFormat);
            __os.writeInt(delay);
            __result.endWriteParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public String end_sayHello(Ice.AsyncResult __iresult)
    {
        IceInternal.OutgoingAsync __result = IceInternal.OutgoingAsync.check(__iresult, this, __sayHello_name);
        try
        {
            if(!__result.__wait())
            {
                try
                {
                    __result.throwUserException();
                }
                catch(Ice.UserException __ex)
                {
                    throw new Ice.UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            IceInternal.BasicStream __is = __result.startReadParams();
            String __ret;
            __ret = __is.readString();
            __result.endReadParams();
            return __ret;
        }
        finally
        {
            if(__result != null)
            {
                __result.cacheMessageBuffers();
            }
        }
    }

    static public void __sayHello_completed(Ice.TwowayCallbackArg1<String> __cb, Ice.AsyncResult __result)
    {
        generated.Demo.HelloPrx __proxy = (generated.Demo.HelloPrx)__result.getProxy();
        String __ret = null;
        try
        {
            __ret = __proxy.end_sayHello(__result);
        }
        catch(Ice.LocalException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        catch(Ice.SystemException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }

    private static final String __shutdown_name = "shutdown";

    public void shutdown()
    {
        shutdown(null, false);
    }

    public void shutdown(java.util.Map<String, String> __ctx)
    {
        shutdown(__ctx, true);
    }

    private void shutdown(java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        end_shutdown(begin_shutdown(__ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_shutdown()
    {
        return begin_shutdown(null, false, false, null);
    }

    public Ice.AsyncResult begin_shutdown(java.util.Map<String, String> __ctx)
    {
        return begin_shutdown(__ctx, true, false, null);
    }

    public Ice.AsyncResult begin_shutdown(Ice.Callback __cb)
    {
        return begin_shutdown(null, false, false, __cb);
    }

    public Ice.AsyncResult begin_shutdown(java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_shutdown(__ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_shutdown(Callback_Hello_shutdown __cb)
    {
        return begin_shutdown(null, false, false, __cb);
    }

    public Ice.AsyncResult begin_shutdown(java.util.Map<String, String> __ctx, Callback_Hello_shutdown __cb)
    {
        return begin_shutdown(__ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_shutdown(IceInternal.Functional_VoidCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_shutdown(null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_shutdown(IceInternal.Functional_VoidCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                          IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_shutdown(null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_shutdown(java.util.Map<String, String> __ctx, 
                                          IceInternal.Functional_VoidCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_shutdown(__ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_shutdown(java.util.Map<String, String> __ctx, 
                                          IceInternal.Functional_VoidCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                          IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_shutdown(__ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_shutdown(java.util.Map<String, String> __ctx, 
                                           boolean __explicitCtx, 
                                           boolean __synchronous, 
                                           IceInternal.Functional_VoidCallback __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                           IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_shutdown(__ctx, 
                              __explicitCtx, 
                              __synchronous, 
                              new IceInternal.Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }

    private Ice.AsyncResult begin_shutdown(java.util.Map<String, String> __ctx, 
                                           boolean __explicitCtx, 
                                           boolean __synchronous, 
                                           IceInternal.CallbackBase __cb)
    {
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__shutdown_name, __cb);
        try
        {
            __result.prepare(__shutdown_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            __result.writeEmptyParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public void end_shutdown(Ice.AsyncResult __iresult)
    {
        __end(__iresult, __shutdown_name);
    }

    public static HelloPrx checkedCast(Ice.ObjectPrx __obj)
    {
        return checkedCastImpl(__obj, ice_staticId(), HelloPrx.class, HelloPrxHelper.class);
    }

    public static HelloPrx checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __ctx, ice_staticId(), HelloPrx.class, HelloPrxHelper.class);
    }

    public static HelloPrx checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return checkedCastImpl(__obj, __facet, ice_staticId(), HelloPrx.class, HelloPrxHelper.class);
    }

    public static HelloPrx checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), HelloPrx.class, HelloPrxHelper.class);
    }

    public static HelloPrx uncheckedCast(Ice.ObjectPrx __obj)
    {
        return uncheckedCastImpl(__obj, HelloPrx.class, HelloPrxHelper.class);
    }

    public static HelloPrx uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return uncheckedCastImpl(__obj, __facet, HelloPrx.class, HelloPrxHelper.class);
    }

    public static final String[] __ids =
    {
        "::Demo::Hello",
        "::Ice::Object"
    };

    public static String ice_staticId()
    {
        return __ids[0];
    }

    public static void __write(IceInternal.BasicStream __os, HelloPrx v)
    {
        __os.writeProxy(v);
    }

    public static HelloPrx __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            HelloPrxHelper result = new HelloPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }

    public static final long serialVersionUID = 0L;
}