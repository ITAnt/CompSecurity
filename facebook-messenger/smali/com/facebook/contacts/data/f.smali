.class Lcom/facebook/contacts/data/f;
.super Lcom/facebook/inject/d;
.source "ContactsModule.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/facebook/inject/d",
        "<",
        "Lcom/facebook/contacts/contactslist/e;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/facebook/contacts/data/d;


# direct methods
.method private constructor <init>(Lcom/facebook/contacts/data/d;)V
    .locals 0

    .prologue
    .line 54
    iput-object p1, p0, Lcom/facebook/contacts/data/f;->a:Lcom/facebook/contacts/data/d;

    invoke-direct {p0}, Lcom/facebook/inject/d;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/contacts/data/d;Lcom/facebook/contacts/data/e;)V
    .locals 0

    .prologue
    .line 54
    invoke-direct {p0, p1}, Lcom/facebook/contacts/data/f;-><init>(Lcom/facebook/contacts/data/d;)V

    return-void
.end method


# virtual methods
.method public a()Lcom/facebook/contacts/contactslist/e;
    .locals 3

    .prologue
    .line 58
    new-instance v1, Lcom/facebook/contacts/contactslist/e;

    invoke-virtual {p0}, Lcom/facebook/contacts/data/f;->e()Lcom/facebook/inject/ab;

    move-result-object v0

    const-class v2, Landroid/content/Context;

    invoke-interface {v0, v2}, Lcom/facebook/inject/ab;->a(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    invoke-direct {v1, v0}, Lcom/facebook/contacts/contactslist/e;-><init>(Landroid/content/Context;)V

    return-object v1
.end method

.method public synthetic b()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 54
    invoke-virtual {p0}, Lcom/facebook/contacts/data/f;->a()Lcom/facebook/contacts/contactslist/e;

    move-result-object v0

    return-object v0
.end method
