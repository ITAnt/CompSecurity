.class Lcom/rsa/mobilesdk/sdk/LocationRetriever$2;
.super Landroid/os/Handler;
.source "LocationRetriever.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/rsa/mobilesdk/sdk/LocationRetriever;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/rsa/mobilesdk/sdk/LocationRetriever;


# direct methods
.method constructor <init>(Lcom/rsa/mobilesdk/sdk/LocationRetriever;)V
    .locals 0

    .prologue
    .line 76
    iput-object p1, p0, Lcom/rsa/mobilesdk/sdk/LocationRetriever$2;->this$0:Lcom/rsa/mobilesdk/sdk/LocationRetriever;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 1
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 78
    iget-object v0, p0, Lcom/rsa/mobilesdk/sdk/LocationRetriever$2;->this$0:Lcom/rsa/mobilesdk/sdk/LocationRetriever;

    # invokes: Lcom/rsa/mobilesdk/sdk/LocationRetriever;->handleSilenceExpired()V
    invoke-static {v0}, Lcom/rsa/mobilesdk/sdk/LocationRetriever;->access$100(Lcom/rsa/mobilesdk/sdk/LocationRetriever;)V

    .line 79
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 80
    return-void
.end method
