.class Lcom/facebook/orca/server/module/j;
.super Lcom/facebook/inject/d;
.source "MessagesServiceModule.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/facebook/inject/d",
        "<",
        "Lcom/facebook/fbservice/service/e;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/facebook/orca/server/module/a;


# direct methods
.method private constructor <init>(Lcom/facebook/orca/server/module/a;)V
    .locals 0

    .prologue
    .line 264
    iput-object p1, p0, Lcom/facebook/orca/server/module/j;->a:Lcom/facebook/orca/server/module/a;

    invoke-direct {p0}, Lcom/facebook/inject/d;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/orca/server/module/a;Lcom/facebook/orca/server/module/b;)V
    .locals 0

    .prologue
    .line 264
    invoke-direct {p0, p1}, Lcom/facebook/orca/server/module/j;-><init>(Lcom/facebook/orca/server/module/a;)V

    return-void
.end method


# virtual methods
.method public a()Lcom/facebook/fbservice/service/e;
    .locals 1

    .prologue
    .line 269
    const-class v0, Lcom/facebook/orca/stickers/w;

    invoke-virtual {p0, v0}, Lcom/facebook/orca/server/module/j;->a(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/fbservice/service/e;

    return-object v0
.end method

.method public synthetic b()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 264
    invoke-virtual {p0}, Lcom/facebook/orca/server/module/j;->a()Lcom/facebook/fbservice/service/e;

    move-result-object v0

    return-object v0
.end method
