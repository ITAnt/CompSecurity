.class Lcom/facebook/orca/app/cr;
.super Lcom/facebook/inject/d;
.source "MessagesModule.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/facebook/inject/d",
        "<",
        "Lcom/facebook/orca/threadlist/m;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/facebook/orca/app/h;


# direct methods
.method private constructor <init>(Lcom/facebook/orca/app/h;)V
    .locals 0

    .prologue
    .line 1447
    iput-object p1, p0, Lcom/facebook/orca/app/cr;->a:Lcom/facebook/orca/app/h;

    invoke-direct {p0}, Lcom/facebook/inject/d;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/orca/app/h;Lcom/facebook/orca/app/i;)V
    .locals 0

    .prologue
    .line 1447
    invoke-direct {p0, p1}, Lcom/facebook/orca/app/cr;-><init>(Lcom/facebook/orca/app/h;)V

    return-void
.end method


# virtual methods
.method public a()Lcom/facebook/orca/threadlist/m;
    .locals 7

    .prologue
    .line 1451
    new-instance v0, Lcom/facebook/orca/threadlist/m;

    const-class v1, Landroid/content/Context;

    invoke-virtual {p0, v1}, Lcom/facebook/orca/app/cr;->a(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/Context;

    const-class v2, Lcom/facebook/orca/threadlist/af;

    invoke-virtual {p0, v2}, Lcom/facebook/orca/app/cr;->a(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/facebook/orca/threadlist/af;

    const-class v3, Lcom/facebook/orca/f/k;

    invoke-virtual {p0, v3}, Lcom/facebook/orca/app/cr;->a(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/facebook/orca/f/k;

    const-class v4, Lcom/facebook/fbservice/ops/c;

    invoke-virtual {p0, v4}, Lcom/facebook/orca/app/cr;->a(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/facebook/fbservice/ops/c;

    const-class v5, Lcom/facebook/orca/threads/FolderType;

    const-class v6, Lcom/facebook/orca/annotations/CurrentFolder;

    invoke-virtual {p0, v5, v6}, Lcom/facebook/orca/app/cr;->b(Ljava/lang/Class;Ljava/lang/Class;)Ljavax/inject/a;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Lcom/facebook/orca/threadlist/m;-><init>(Landroid/content/Context;Lcom/facebook/orca/threadlist/af;Lcom/facebook/orca/f/k;Lcom/facebook/fbservice/ops/c;Ljavax/inject/a;)V

    return-object v0
.end method

.method public synthetic b()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1447
    invoke-virtual {p0}, Lcom/facebook/orca/app/cr;->a()Lcom/facebook/orca/threadlist/m;

    move-result-object v0

    return-object v0
.end method
