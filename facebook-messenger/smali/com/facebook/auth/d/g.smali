.class Lcom/facebook/auth/d/g;
.super Lcom/facebook/inject/d;
.source "LoggedInUserAuthModule.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/facebook/inject/d",
        "<",
        "Lcom/facebook/auth/protocol/h;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/facebook/auth/d/b;


# direct methods
.method private constructor <init>(Lcom/facebook/auth/d/b;)V
    .locals 0

    .prologue
    .line 178
    iput-object p1, p0, Lcom/facebook/auth/d/g;->a:Lcom/facebook/auth/d/b;

    invoke-direct {p0}, Lcom/facebook/inject/d;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/auth/d/b;Lcom/facebook/auth/d/c;)V
    .locals 0

    .prologue
    .line 178
    invoke-direct {p0, p1}, Lcom/facebook/auth/d/g;-><init>(Lcom/facebook/auth/d/b;)V

    return-void
.end method


# virtual methods
.method public a()Lcom/facebook/auth/protocol/h;
    .locals 4

    .prologue
    .line 182
    new-instance v3, Lcom/facebook/auth/protocol/h;

    const-class v0, Lcom/facebook/auth/protocol/j;

    invoke-virtual {p0, v0}, Lcom/facebook/auth/d/g;->a(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/auth/protocol/j;

    const-class v1, Lcom/facebook/user/ac;

    invoke-virtual {p0, v1}, Lcom/facebook/auth/d/g;->a(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/facebook/user/ac;

    const-class v2, Lcom/facebook/common/time/a;

    invoke-virtual {p0, v2}, Lcom/facebook/auth/d/g;->a(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/facebook/common/time/a;

    invoke-direct {v3, v0, v1, v2}, Lcom/facebook/auth/protocol/h;-><init>(Lcom/facebook/auth/protocol/j;Lcom/facebook/user/ac;Lcom/facebook/common/time/a;)V

    return-object v3
.end method

.method public synthetic b()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 178
    invoke-virtual {p0}, Lcom/facebook/auth/d/g;->a()Lcom/facebook/auth/protocol/h;

    move-result-object v0

    return-object v0
.end method
