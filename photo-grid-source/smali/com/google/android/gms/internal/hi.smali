.class final Lcom/google/android/gms/internal/hi;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/google/android/gms/internal/hh;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/hh;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/hi;->a:Lcom/google/android/gms/internal/hh;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/hi;->a:Lcom/google/android/gms/internal/hh;

    iget-object v0, v0, Lcom/google/android/gms/internal/hh;->a:Lcom/google/android/gms/internal/bg;

    invoke-interface {v0}, Lcom/google/android/gms/internal/bg;->a()V

    return-void
.end method
