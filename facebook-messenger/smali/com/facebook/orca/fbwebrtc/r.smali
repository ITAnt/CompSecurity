.class Lcom/facebook/orca/fbwebrtc/r;
.super Ljava/lang/Object;
.source "WebrtcIncallActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnDismissListener;


# instance fields
.field final synthetic a:Lcom/facebook/orca/fbwebrtc/WebrtcIncallActivity;


# direct methods
.method constructor <init>(Lcom/facebook/orca/fbwebrtc/WebrtcIncallActivity;)V
    .locals 0

    .prologue
    .line 862
    iput-object p1, p0, Lcom/facebook/orca/fbwebrtc/r;->a:Lcom/facebook/orca/fbwebrtc/WebrtcIncallActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 1

    .prologue
    .line 865
    iget-object v0, p0, Lcom/facebook/orca/fbwebrtc/r;->a:Lcom/facebook/orca/fbwebrtc/WebrtcIncallActivity;

    invoke-virtual {v0}, Lcom/facebook/orca/fbwebrtc/WebrtcIncallActivity;->finish()V

    .line 866
    return-void
.end method
