.class final Lcom/roidapp/cloudlib/f;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field final synthetic a:Lcom/roidapp/cloudlib/d;


# direct methods
.method constructor <init>(Lcom/roidapp/cloudlib/d;)V
    .locals 0

    .prologue
    .line 189
    iput-object p1, p0, Lcom/roidapp/cloudlib/f;->a:Lcom/roidapp/cloudlib/d;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/content/DialogInterface;I)V
    .locals 1

    .prologue
    .line 194
    iget-object v0, p0, Lcom/roidapp/cloudlib/f;->a:Lcom/roidapp/cloudlib/d;

    iget-object v0, v0, Lcom/roidapp/cloudlib/d;->b:Lcom/roidapp/cloudlib/AccountMgrActivity;

    invoke-static {v0}, Lcom/roidapp/cloudlib/AccountMgrActivity;->c(Lcom/roidapp/cloudlib/AccountMgrActivity;)V

    .line 195
    return-void
.end method
