.class Lcom/facebook/push/fbpushdata/d;
.super Lcom/facebook/inject/d;
.source "FbPushDataModule.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/facebook/inject/d",
        "<",
        "Lcom/facebook/push/fbpushdata/e;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/facebook/push/fbpushdata/b;


# direct methods
.method private constructor <init>(Lcom/facebook/push/fbpushdata/b;)V
    .locals 0

    .prologue
    .line 41
    iput-object p1, p0, Lcom/facebook/push/fbpushdata/d;->a:Lcom/facebook/push/fbpushdata/b;

    invoke-direct {p0}, Lcom/facebook/inject/d;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/push/fbpushdata/b;Lcom/facebook/push/fbpushdata/c;)V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0, p1}, Lcom/facebook/push/fbpushdata/d;-><init>(Lcom/facebook/push/fbpushdata/b;)V

    return-void
.end method


# virtual methods
.method public a()Lcom/facebook/push/fbpushdata/e;
    .locals 6

    .prologue
    .line 46
    new-instance v0, Lcom/facebook/push/fbpushdata/e;

    const-class v1, Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {p0, v1}, Lcom/facebook/push/fbpushdata/d;->a(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/fasterxml/jackson/databind/ObjectMapper;

    const-class v2, Lcom/facebook/push/mqtt/v;

    invoke-virtual {p0, v2}, Lcom/facebook/push/fbpushdata/d;->a(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/facebook/push/mqtt/v;

    const-class v3, Lcom/facebook/push/c2dm/y;

    invoke-virtual {p0, v3}, Lcom/facebook/push/fbpushdata/d;->a(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/facebook/push/c2dm/y;

    const-class v4, Lcom/facebook/analytics/cn;

    invoke-virtual {p0, v4}, Lcom/facebook/push/fbpushdata/d;->a(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/facebook/analytics/cn;

    const-class v5, Landroid/content/Context;

    invoke-virtual {p0, v5}, Lcom/facebook/push/fbpushdata/d;->a(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/content/Context;

    invoke-direct/range {v0 .. v5}, Lcom/facebook/push/fbpushdata/e;-><init>(Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/facebook/push/mqtt/v;Lcom/facebook/push/c2dm/y;Lcom/facebook/analytics/cn;Landroid/content/Context;)V

    return-object v0
.end method

.method public synthetic b()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 41
    invoke-virtual {p0}, Lcom/facebook/push/fbpushdata/d;->a()Lcom/facebook/push/fbpushdata/e;

    move-result-object v0

    return-object v0
.end method
