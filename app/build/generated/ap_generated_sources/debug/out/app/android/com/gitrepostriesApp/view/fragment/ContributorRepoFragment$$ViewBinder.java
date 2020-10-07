// Generated code from Butter Knife. Do not modify!
package app.android.com.gitrepostriesApp.view.fragment;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ContributorRepoFragment$$ViewBinder<T extends ContributorRepoFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131230929, "field 'mProgressbar'");
    target.mProgressbar = finder.castView(view, 2131230929, "field 'mProgressbar'");
    view = finder.findRequiredView(source, 2131230880, "field 'mUserRepoImageview'");
    target.mUserRepoImageview = finder.castView(view, 2131230880, "field 'mUserRepoImageview'");
    view = finder.findRequiredView(source, 2131231027, "field 'mName'");
    target.mName = finder.castView(view, 2131231027, "field 'mName'");
    view = finder.findRequiredView(source, 2131231031, "field 'mFullname'");
    target.mFullname = finder.castView(view, 2131231031, "field 'mFullname'");
    view = finder.findRequiredView(source, 2131231030, "field 'mDescription'");
    target.mDescription = finder.castView(view, 2131231030, "field 'mDescription'");
    view = finder.findRequiredView(source, 2131230905, "field 'mRecyclerView'");
    target.mRecyclerView = finder.castView(view, 2131230905, "field 'mRecyclerView'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends ContributorRepoFragment> implements Unbinder {
    private T target;

    protected InnerUnbinder(T target) {
      this.target = target;
    }

    @Override
    public final void unbind() {
      if (target == null) throw new IllegalStateException("Bindings already cleared.");
      unbind(target);
      target = null;
    }

    protected void unbind(T target) {
      target.mProgressbar = null;
      target.mUserRepoImageview = null;
      target.mName = null;
      target.mFullname = null;
      target.mDescription = null;
      target.mRecyclerView = null;
    }
  }
}
