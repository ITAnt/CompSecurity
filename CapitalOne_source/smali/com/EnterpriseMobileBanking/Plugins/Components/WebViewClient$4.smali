.class Lcom/EnterpriseMobileBanking/Plugins/Components/WebViewClient$4;
.super Ljava/lang/Object;
.source "WebViewClient.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/EnterpriseMobileBanking/Plugins/Components/WebViewClient;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/EnterpriseMobileBanking/Plugins/Components/WebViewClient;

.field final synthetic val$view:Landroid/webkit/WebView;


# direct methods
.method constructor <init>(Lcom/EnterpriseMobileBanking/Plugins/Components/WebViewClient;Landroid/webkit/WebView;)V
    .locals 0

    .prologue
    .line 312
    iput-object p1, p0, Lcom/EnterpriseMobileBanking/Plugins/Components/WebViewClient$4;->this$0:Lcom/EnterpriseMobileBanking/Plugins/Components/WebViewClient;

    iput-object p2, p0, Lcom/EnterpriseMobileBanking/Plugins/Components/WebViewClient$4;->val$view:Landroid/webkit/WebView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 316
    iget-object v0, p0, Lcom/EnterpriseMobileBanking/Plugins/Components/WebViewClient$4;->val$view:Landroid/webkit/WebView;

    const-string v1, "javascript: if (typeof mobileAppBackButtonEnabled === \'undefined\') { webview.backButtonActive(false) } else { webview.backButtonActive(mobileAppBackButtonEnabled)}; (function( elements ){ for( var i=0; i<elements.length; i++ ) { var ele = elements[i]; if( ele.target && ele.target == \'_blank\' ) { ele.href +=\'_0targetBlank0\'; }} return; })(document.body.getElementsByTagName( \'a\' ));"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 317
    return-void
.end method
