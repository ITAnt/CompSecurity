.class final Lkik/android/chat/fragment/ps;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Lkik/android/chat/fragment/KikStartGroupFragment;


# direct methods
.method constructor <init>(Lkik/android/chat/fragment/KikStartGroupFragment;)V
    .locals 0

    .prologue
    .line 77
    iput-object p1, p0, Lkik/android/chat/fragment/ps;->a:Lkik/android/chat/fragment/KikStartGroupFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lkik/android/chat/fragment/ps;->a:Lkik/android/chat/fragment/KikStartGroupFragment;

    invoke-virtual {v0}, Lkik/android/chat/fragment/KikStartGroupFragment;->clearComposeTo()V

    .line 82
    return-void
.end method
